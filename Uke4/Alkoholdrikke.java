// kan ikke lage objekter av abstrakt klasse, maa lage subklasse
abstract class Alkoholdrikke extends Drikke implements Alkoholholdig{
    protected double alkoholProsent;
    protected String navn;

    public Alkoholdrikke(double alkoholProsent,
                         String navn) {
        super(navn);
        this.alkoholProsent = alkoholProsent;
    }

    // implementerer metoden fra interfacet
    // husk override (ikke nødvendig, men ganske lurt)
    @Override
    public double getAlkoholprosent() {
        return alkoholProsent;
    }

    public String toString() {
        // toString brukes til aa skrive ut objekter
        return "Alkoholdrikke med navn " + navn;
    }
}
