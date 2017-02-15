abstract class Drikke implements Drikkbar {
    String navn;
    public Drikke(String navn) {
        this.navn = navn;
    }

    // fra Drikkbar
    @Override
    public int getAldersgrense() {
        return 0;
    }
}
