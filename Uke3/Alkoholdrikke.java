// kan ikke lage objekter av abstrakt klasse, maa lage subklasse
abstract class Alkoholdrikke {
    protected double alkoholProsent;
    protected String navn;

    public Alkoholdrikke(double alkoholProsent,
                         String navn) {
        this.alkoholProsent = alkoholProsent;
        this.navn = navn;
    }

    public double getProsent() {
        return alkoholProsent;
    }

    public String toString() {
        // toString brukes til aa skrive ut objekter
        return "Alkoholdrikke med navn " + navn;
    }
}
