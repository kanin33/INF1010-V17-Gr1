class Ol extends Alkoholdrikke {
    protected String humleType;

    public Ol(double alkoholProsent,
                         String navn,
                         String humleType) {
        super(alkoholProsent, navn);
        this.humleType = humleType;
    }

    public String getHumleType() {
        return humleType;
    }

    public String toString() {
        return "Ol av typen " + navn;
    }
}
