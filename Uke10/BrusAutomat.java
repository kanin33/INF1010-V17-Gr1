import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class BrusAutomat {
    private int antBrus;
    private int maxAntBrus;
    private Lock laas;
    private Condition trengerPaafyll;
    private Condition erMerBrus;

    public BrusAutomat(int maxAntBrus) {
        this.maxAntBrus = maxAntBrus;
        antBrus = 0;
        laas = new ReentrantLock();

        trengerPaafyll = laas.newCondition();
        erMerBrus = laas.newCondition();
    }

    public void kjopBrus() {
        laas.lock();
        try {
            while(antBrus == 0) {
                System.out.println("antbrus 0");
                erMerBrus.await();
            }
            antBrus--;
            if(antBrus == 0) {
                // si ifra til paafylleren
                trengerPaafyll.signal();
            }
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        } finally {
            laas.unlock();
        }
    }

    public void fyllPaa() {
        laas.lock();
        try {
            while(antBrus > 0) {
                trengerPaafyll.await();
            }
            antBrus = maxAntBrus;
            erMerBrus.signalAll();
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        } finally {
            laas.unlock();
        }
    }
}
