// må importere Iterator, men ikke Iterable
import java.util.Iterator;

// dette er en itererbar Lenkeliste. Det vil si at
// man kan iterere gjennom elementene som er lagret i den
class LenkeListe<E> implements Iterable<E> {
    private int storrelse = 0;
    private Node forste;
    //private Node siste;

    private class Node {
        // indre klasse kan ikke brukes utenfor
        // LenkeListe-klassen

        // hver node har et objekt av typen E
        E s;
        // noden har en peker til den neste noden
        Node neste;

        Node(E s) {
            this.s = s;
        }
    }

    public int storrelse() {
        return storrelse;
    }

    public boolean erTom() {
        if(forste == null) {
            return true;
        }
        return false;
    }

    public void settInn(E e) {
        leggTilBak(e);
    }

    /**
     * Legger til en ny node foran i listen
     *
     * masse informasjon
     * om hvorden dette fungerer
     *
     * @param s objektet som skal settes inn
     * @return ingenting
     */
    public void leggTilForan(E s) {
        // først lager vi en ny node
        // med det nye objektet som skal legges inn
        Node nyNode = new Node(s);
        if(erTom()) {
            // hvis listen er tom setter vi både første-pekeren
            // og siste-pekeren til å peke på den nye noden
            forste = nyNode;
            //siste = nyNode;
        } else {
            // hvis ikke setter vi inn den nye noden foran
            nyNode.neste = forste;
            forste = nyNode;
        }
        storrelse++;
    }


    public void leggTilBak(E s) {
        // først lager vi en ny node
        // med det nye objektet som skal legges inn
        Node nyNode = new Node(s);
        if(erTom()) {
            // hvis listen er tom setter vi både første-pekeren
            // og siste-pekeren til å peke på den nye noden
            forste = nyNode;
            //siste = nyNode;
        } else {
            // tmp-noden brukes til å finne den siste noden
            // siden vi ikke har noen siste-peker lenger
            Node tmp = forste;
            while(tmp.neste != null) {
                tmp = tmp.neste;
            }
            tmp.neste = nyNode;
        }
        storrelse++;
    }

    public E taUtForan() {//throws TomListeException {
        try{
            if(forste == null) {
                throw new TomListeException();
            }
        } catch (TomListeException e) {
            System.out.println("Tomliste");
            return null;
        }
        // midlertidig lagre den første noden
        Node tmp = forste;
        // endre den første til å bli Node nr 2
        forste = forste.neste;
        // returner verdien til det som tidligere var
        // første node
        return tmp.s;
    }

    public E taUtBak() {
        // case 1
        if(erTom()) {
            return null;
        // case 2
        } else if (forste.neste == null) {
            Node tmp = forste;
            forste = null;
            return tmp.s;
        // case 3
        } else {
            // finn nest-siste node
            Node tmp = forste;
            while(tmp.neste.neste != null) {
                tmp = tmp.neste;
            }
            // midlertidig ta vare på siste noden
            Node tmp2 = tmp.neste;
            // fjern den siste noden fra den neste-siste
            tmp.neste = null;
            // returner verdien som ligger i det som var
            // den siste noden
            return tmp2.s;
        }
    }

    public E hent(int index) {
        if(index >= storrelse) {
            // sjekker om indexen vi leter etter ligger
            // utenfor størrelsen på listen
            return null;
        } else {
            // starter på den første noden
            Node denne = forste;
            int teller = 0;
            while(denne != null) {
                // så lenge vi ikke på slutten av listen
                // (da er denne == null), skal vi sjekke
                // om indeksen vi leter etter er den samme
                // som vi er på nå
                //
                // hvis teller og index er like returnerer
                // vi objektet i noden
                if(teller == index) {
                    return denne.s;
                }
                // hvis ikke øker vi telleren og flytter
                // denne-pekeren ett hakk bort
                teller++;
                denne = denne.neste;
            }
        }
        // hvis vi ikke finner indeksen returnerer
        // vi null
        return null;
    }

    // klasse for en iterator på denne lenkelisten
    private class LenkeIterator implements Iterator<E> {
        // merk at momentanNode blir initialisert til å
        // være det som forste peker på. Hvis vi endrer
        // datastrukturen til lenkelisten (for eksempel
        // setter inn foran) etter at iteratoren er laget,
        // vil ikke momentanNode bli endret
        Node momentanNode = forste;

        public boolean hasNext() {
            // sjekker om det er fler elementer
            return (momentanNode != null);
        }

        public E next() {
            // henter ut verdien lagret i momentanNode
            // og flytter den ett hakk bort.
            // Legg merke til at vi henter ut verdien
            // FØR vi endrer momentanNode.
            //Node tmp = momentanNode;
            E info = momentanNode.s;
            momentanNode = momentanNode.neste;
            return info;
        }

        public void remove() {
            // ikke implementert

        }
    }

    // denne metoden returnerer en iterator tilhørende
    // denne lenkelisten
    public Iterator<E> iterator() {
        return new LenkeIterator();
    }
}
