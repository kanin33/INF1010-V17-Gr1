class Basketspiller {
    // initialiserer variabler
    private String navn;
    private double hoyde;
    private int antKamper;

    public Basketspiller(String navn, double hoyde,
                         int antKamper) {
        // kontruktor
        // husk this
        this.navn = navn;
        this.hoyde = hoyde;
        this.antKamper = antKamper;
    }

    public int hentAntallKamper() {
        // get-funksjon for aa faa antallkamper
        return antKamper;
    }
}
