class Vin extends Alkoholdrikke {
    protected String drueType;

    public Vin(double alkoholProsent,
               String navn,
               String drueType) {
        // maa kalle paa super foae noe annet
        super(alkoholProsent, navn);
        this.drueType = drueType;
    }

    public String getDrueType() {
        return drueType;
    }
}
