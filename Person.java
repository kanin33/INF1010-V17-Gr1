class Person {
    String navn;
    int alder;
    String bosted;
    public Person(String navn, int alder, String bosted) {
        this.navn = navn;
        this.alder = alder;
        this.bosted = bosted;
    }

    public int[] sov(int timer) {
        int[] tallListe = new int[timer];
        for(int i = 0; i < timer; i++) {
            System.out.println("sovet " + i + " timer");
            tallListe[i] = i;
        }
        return tallListe;
    }
}
