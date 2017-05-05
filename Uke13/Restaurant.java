import java.util.LinkedList;

class Restaurant {
    private static final int ANTALL_KOKKER = 5;
    private static final int ANTALL_SERVITORER = 4;
    private static final int ANTALL_KUNDER = 1000;
    private static final int TID = 10;

    public static void main(String[] args) {
        Bord bord = new Bord(5);

        Kokk[] kokker = lagNyeKokker(bord);
        Servitor[] servitorer = lagNyeServitorer(bord);
        LinkedList<Kunde> kunder = lagNyeKunder(bord);

        bord.startResturanten(servitorer, kokker, kunder, TID);
    }

    public static Kokk[] lagNyeKokker(Bord bord) {
        Kokk[] kokker = new Kokk[ANTALL_KOKKER];
        for(int i = 0; i < ANTALL_KOKKER; i++) {
            kokker[i] = new Kokk(bord);
        }
        return kokker;
    }


    public static Servitor[] lagNyeServitorer(Bord bord) {
        Servitor[] servitorer = new Servitor[ANTALL_SERVITORER];
        for(int i = 0; i < ANTALL_SERVITORER; i++) {
            servitorer[i] = new Servitor(bord);
        }
        return servitorer;
    }
    public static LinkedList<Kunde> lagNyeKunder(Bord bord) {
        LinkedList<Kunde> kunder = new LinkedList<Kunde>();
        for(int i = 0; i < ANTALL_KUNDER; i++) {
            kunder.add(new Kunde());
        }
        return kunder;
    }
}
