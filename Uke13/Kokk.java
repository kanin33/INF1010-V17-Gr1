import java.util.Random;
import java.util.NoSuchElementException;

class Kokk implements Runnable {
    private Bord bord;
    private static int idGenerator = 0;
    private int id;
    private Random random;

    public Kokk(Bord bord) {
        this.bord = bord;
        this.id = idGenerator++;
        random = new Random();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextInt(1000));
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        }

        while(bord.plassTilFlereTallerkner()) {
            bord.leggTallerken(lagTallerken(), this);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch(InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        System.out.printf("%s er ferdig\n", this);
    }

    private Tallerken lagTallerken() {
        return new Tallerken();
    }

    public String toString() {
        return getClass().getName() + " " + id;
    }
}
