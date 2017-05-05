import java.util.Random;
import java.util.NoSuchElementException;

class Servitor implements Runnable {
    private Bord bord;
    private static int idGenerator = 0;
    private int id;
    private Random random;

    public Servitor(Bord bord) {
        this.bord = bord;
        this.id = idGenerator++;
        random = new Random();
    }

    @Override
    public void run() {
        try{
            Kunde kunde;
            while((kunde = bord.hentKunde()) != null) {
                Tallerken tallerken = bord.hentTallerken(this);
                kunde.setTallerken(tallerken);

                try {
                    Thread.sleep(random.nextInt(1000));
                } catch(InterruptedException e) {
                    System.out.println("Interrupted");
                }

            }
        } catch(NoSuchElementException e) {}
        System.out.printf("%s er ferdig\n", this);
    }

    public String toString() {
        return getClass().getName() + " " + id;
    }
}
