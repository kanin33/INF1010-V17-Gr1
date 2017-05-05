class Kunde {
    private Tallerken tallerken;

    public Kunde() {
        tallerken = null;
    }

    public boolean faattTallerken() {
        // Sjekker om kunden har fått tallerknen sin
        return tallerken != null;
    }

    public void setTallerken(Tallerken t) {
        // Gi kunden tallerknen
        tallerken = t;
    }
}
