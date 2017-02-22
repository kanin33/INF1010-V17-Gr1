class TestLenkeListe {
    public static void main(String[] args) {
        // lager en lenkeliste for stringer
        LenkeListe<String> lenkeListe = new LenkeListe<String>();

        // setter inn to stringer
        lenkeListe.leggTil("Hei");
        lenkeListe.leggTil("Heihei");
        // tar ut element nr 0 og nr 1
        // nr 0 burde være "Hei" og nr 1 burde
        // være "Heihei"
        System.out.println(lenkeListe.hent(0));
        System.out.println(lenkeListe.hent(1));
    }
}
