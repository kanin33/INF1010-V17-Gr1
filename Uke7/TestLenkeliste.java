import java.util.Iterator;

class TestLenkeliste {
    public static void main(String[] args) {
        LenkeListe<String> l = new LenkeListe<String>();

        // legger inn elementer og lager en iterator
        l.leggTilBak("hei");
        Iterator<String> i = l.iterator();
        l.leggTilBak("hallo");
        l.leggTilBak("hey");
        l.leggTilBak("heisann");

        // denne while-løkken er ekvivalent med --
        String s1;
        while(i.hasNext()) {
            s1 = i.next();
            System.out.println(s1);
        }

        // -- denne for-løkken
        for(String s : l) {
            System.out.println(s);
        }
    }
}
