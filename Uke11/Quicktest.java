class Quicktest {
    public static void main(String[] args) {
        Lenkeliste<String> l = new Lenkeliste<String>();
        l.settInnForan("a");
        l.settInnForan("ab");
        l.settInnForan("vjr");
        l.settInnForan("ijg");
        l.settInnForan("iu");

        Sorterer<String> sort = new Sorterer(l);
        sort.sorter();

        for(String i : l) {
            System.out.println(i);
        }
    }
}
