// Eksempel som viser hvordan man leser inn en fil
import java.util.Scanner;
import java.io.File;

class LesInnFil {
    public static void main(String[] args) {
        // Må ha try-catch når man bruker Scanner
        try {
            // Lag et nytt Scanner-objekt
            // Det er dette som skal lese inn filen
            Scanner sc = new Scanner(new File("innfil.txt"));
            // Så lenge det er en neste linje skal man lese videre
            while(sc.hasNextLine()) {
                // Les inn linjen og split den opp på hvert mellomrom
                String[] ord = sc.nextLine().split(" ");
                // Hvis det første ordet er Hei, bruk lesLinjeMedHei-metoden
                if(ord[0].equals("Hei")) {
                    lesLinjeMedHei(ord);
                } else if(ord[0].equals("Hallo")) {
                    lesLinjeMedHallo(ord);
                } else if(ord[0].equals("Hello")) {
                    lesLinjeMedHello(ord);
                } else {
                    System.out.println("Filformat ikke støttet");
                }
            }
        } catch (Exception e) {
            System.out.println("Noe gikk galt, kanskje filen ikke finnes?");
        }
    }

    public static void lesLinjeMedHei(String[] ord) {
        System.out.println("Første ord er " + ord[1]);
        System.out.println("Andre ord eri " + ord[2]);
        // gjør om string til int
        int tall = Integer.parseInt(ord[3]);
        System.out.println("Siste ordet er et tall: " + tall);
    }

    public static void lesLinjeMedHallo(String[] ord) {
        System.out.println("Denne funksjonen gjør ingenting");
    }

    public static void lesLinjeMedHello(String[] ord) {
        System.out.println("Denne funksjonen gjør heller ingenting");
    }
}
