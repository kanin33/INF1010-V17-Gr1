class LenkeListe<E> {
    private int storrelse = 0;
    private Node forste;
    private Node siste;

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

    public void leggTil(E s) {
        // først lager vi en ny node
        // med det nye objektet som skal legges inn
        Node nyNode = new Node(s);
        if(forste == null) {
            // hvis listen er tom setter vi både første-pekeren
            // og siste-pekeren til å peke på den nye noden
            forste = nyNode;
            siste = nyNode;
        } else {
            // hvis ikke setter vi inn den nye noden bakerst
            siste.neste = nyNode;
            siste = nyNode;
        }
        storrelse++;
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
}
