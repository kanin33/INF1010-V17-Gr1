class Main {
    public static void main(String[] args) {
        // tester
        testBasketspiller();
        testBasketlag();
    }

    public static void testBasketspiller() {
        // lag et Basketspiller-objekt
        Basketspiller s = new Basketspiller("Kobe",
                                             2.02,
                                             100);
        // sjekk at antallkamper returnert er riktig
        if(s.hentAntallKamper() == 100) {
            System.out.println("Testen fungerte");
        } else {
            System.out.println("Testen fungerte ikke");
        }
    }

    public static void testBasketlag() {
        // lag et Basketspillerobjekt
        Basketspiller b = new Basketspiller("Jordan",
                                            1.96, 400);
        // lag et Basketlagobjekt
        Basketlag l = new Basketlag("Abelz gainerz",
                                    2);
        // legg til spiller på laget
        l.leggTilSpiller(b);
        System.out.println("Tester sett inn paa ledig plass");
        // sjekk at det gaar an aa legge til en spiller til
        if(l.leggTilSpiller(b)) {
            System.out.println("Testen gikk bra");
        } else {
            System.out.println("Testen gikk ikke bra");
        }
        System.out.println("Tester sett inn, ikke ledig");
        // sjekk at det ikke gaar an aa sette inn enda en
        if(!l.leggTilSpiller(b)) {
            System.out.println("Testen gikk bra");
        } else {
            System.out.println("Testen gikk ikke bra");
        }

    }
}
