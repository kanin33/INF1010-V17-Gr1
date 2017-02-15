// Her velger vi å bruke kaffe-klassen og implementere
// alkoholholdig
//
// Kunne også brukt Whiskey-klasen og implementert
// koffeinholdig
class Irish extends Kaffe implements Alkoholholdig {
    public Irish(String navn, double koffeininnhold) {
        super(navn, koffeininnhold);
    }

    public double getAlkoholprosent() {
        return 20;
    }
}
