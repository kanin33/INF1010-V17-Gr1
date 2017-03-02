class LenkeListe<E extends HarFireHjul> {
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
        if(e.kjorBar()) {
            leggTilForan(e);
        } else {
            leggTilBak(e);
        }
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

    public E taUtForan() {
        if(forste == null) {
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
}
