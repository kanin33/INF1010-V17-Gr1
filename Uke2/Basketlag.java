class Basketlag {
    // initialiserer variabler
    private String navn;
    private Basketspiller[] spillere; // array med basketspillere

    public Basketlag(String navn, int antallSpillere) {
        // kontruktor
        this.navn = navn;
        spillere = new Basketspiller[antallSpillere];
    }

    public boolean leggTilSpiller(Basketspiller s) {
        // legg til spiller hvis det er ledig plass
        for(int i = 0; i < spillere.length; i++) {
            // hvis plassen er null er det ledig
            if(spillere[i] == null) {
                spillere[i] = s;
                // returner, saa ikke lokken kjorer lenger
                return true;
            }
        }
        // returner false hvis det er fullt
        return false;
    }
}
