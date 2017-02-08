class Hvitvin extends Vin {
    public Hvitvin(double alkoholProsent,
               String navn,
               String drueType) {
        super(alkoholProsent, navn, drueType);
    }

    public void printHvitvin() {
        System.out.println("Hvitvin");
    }
}
