import java.time.LocalTime;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bord extends LinkedList<Tallerken> {
    private int kapasitet;
    private int totalTallerkner = 0;
    private int antallKunder;
    private boolean ferdig = false;
    private LinkedList<Kunde> kunder;

    private Lock lock = new ReentrantLock();
    private Lock kundeLock = new ReentrantLock();
    private Lock tallerkenLock = new ReentrantLock();
    private Condition ikkeTomt = lock.newCondition();
    private Condition ikkeFullt = lock.newCondition();
    private Condition tidenErUte = lock.newCondition();
    private LocalTime sluttid;

    public Bord(int kapasitet) {
        this.kapasitet = kapasitet;
    }

    public Kunde hentKunde() throws NoSuchElementException {
        kundeLock.lock();
        try {
            if(ferdig) return null;
            return kunder.pop();
        } finally {
            kundeLock.unlock();
        }
    }

    public boolean plassTilFlereTallerkner() {
        tallerkenLock.lock();
        try {
            if (ferdig) return false;
            return totalTallerkner < kunder.size();
        } finally {
            tallerkenLock.unlock();
        }
    }

    public void leggTallerken(Tallerken tallerken, Kokk kokk) {
        lock.lock();
        try {
            while(this.size() >= kapasitet) {
                // må vente siden bordet er fullt
                ikkeFullt.await();
            }
            System.out.println("Mottar en tallerken fra " + kokk + ".");
            this.add(tallerken);
            totalTallerkner++;

            if((LocalTime.now()).compareTo(sluttid) > 0) {
                tidenErUte.signal();
            } else {
                ikkeTomt.signal();
            }
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        }finally {
            lock.unlock();
        }
    }

    public Tallerken hentTallerken(Servitor servitor) {
        lock.lock();
        try {
            while(this.isEmpty()) {
                ikkeTomt.await();
            }
            System.out.println(servitor + " henter en tallerken.");
            Tallerken retur = this.pop();

            if((LocalTime.now()).compareTo(sluttid) > 0) {
                tidenErUte.signal();
            } else {
                ikkeFullt.signal();
            }
            return retur;
        } catch(InterruptedException e) {
            System.out.println("Inerrupted");
            return null;
        } finally {
            lock.unlock();
        }
    }

    public void startResturanten(Servitor[] servitorer, Kokk[] kokker,
                                 LinkedList<Kunde> kunder, int tid) {
        this.kunder = kunder;
        this.antallKunder = kunder.size();
        LocalTime startTid = LocalTime.now();
        this.sluttid = startTid.plusSeconds((long) tid);

        for(Kokk kokk : kokker) {
            new Thread(kokk).start();
        }
        for(Servitor servitor : servitorer) {
            new Thread(servitor).start();
        }

        lock.lock();
        try {
            while((LocalTime.now()).compareTo(sluttid) < 0) {
                tidenErUte.await();
            }
            ferdig = true;
            if(kunder.isEmpty()) {
                System.out.println("Alle kunder fikk mat");
            } else {
                System.out.println("Ikke alle kundene fikk mat");
            }
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        } finally {
            lock.unlock();
        }
    }
}
