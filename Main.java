import java.util.Arrays;
import java.io.File;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("tall"));
            while(sc.hasNextInt()) {
                System.out.println(sc.nextInt());
            }
        } catch(Exception e) {
            System.out.println("Noe gikk galt");
        }
        int i = 1; int j = 2;
        System.out.println("hei");
        Person p = new Person("Tale", 25, "Adamstuen");
        int[] tallListe = p.sov(8);
        System.out.println(Arrays.toString(p.sov(8)));
        for(int k : tallListe) {
            System.out.print(k + " ");
        }
        System.out.println();
    }
}
