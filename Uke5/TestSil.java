class TestSil {
    public static void main(String[] args) {
        // lager en sil for stringer
        // merk at String implementerer Comparable
        // (sjekk gjerne dokumentasjonenen til String)
        MinMaksSil<String> m = new MinMaksSil<String>();
        m.sil("Hei");
        m.sil("Aaaaa");
        m.sil("Bbb");
        // burde skrive ut "Hei" som største
        // og "Aaaaa" som minste (alfabetisk sortert)
        m.skriv();

        // lager en sil for personer (Person-klassen vår
        // implementerer Comparable)
        MinMaksSil<Person> m2 = new MinMaksSil<Person>();
        m2.sil(new Person("Tale", 25));
        m2.sil(new Person("Bendik", 25));
        m2.sil(new Person("Alf", 50));
        m2.sil(new Person("Trym", 17));
        m2.skriv();
    }
}
