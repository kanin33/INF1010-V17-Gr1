import java.util.* ;
class Lenkeliste<T extends Comparable<T> > implements Iterable<T> {

    public Node lh = null ; // listehode
    public Node bak = null ; // skal peke på bakerste node

    private class Node {
        T data ;
        Node neste = null ;
        
        Node (T s) {
            data = s;
        }

        void skriv() {
            if (neste != null) neste.skriv();
            System.out.println("Rekursiv utskrift av objektet: " + data.toString() );
        }
    }

    Lenkeliste() {
        lh = new Node(null);
        // lh.neste peker nå på detforan før pekte på
    }

    boolean tom() { return lh.neste == null; }

    
    public Iterator<T> iterator() { 
        return new ListeIterator ();
    }
        
    private  class ListeIterator implements Iterator<T> {
        
        final static int TILSTAND_A = 0;
        final static int TILSTAND_B = 1;
        
        int tilstand = TILSTAND_A; // én av de to ovenfor

        Node pos = lh;

        public boolean hasNext() {
            return    (tilstand == TILSTAND_A && pos.neste != null)
                   || (tilstand == TILSTAND_B && pos.neste.neste != null);
        }

        public T next() {
                if (tilstand == TILSTAND_A) ;  // ikke flytt pos
                else pos = pos.neste;            
                tilstand = TILSTAND_B;
                return pos.neste.data;
        }

        public void remove() {
            
            /* fjerner den siste som ble henta, dvs. pos.neste;
            // men bare dersom et objekt er henta siden
            // forrige gang fjern ble kalt */
            
            if ( tilstand == TILSTAND_B) {
                pos.neste = pos.neste.neste; // hopper over pos.neste
                tilstand = TILSTAND_A;
            } else System.out.println("Feil kall på remove()");
        }
        
    }//class ListIterator

    /* Metoder for å sortere
       beholderen/lenkelista
       ved hjelp av quicksort
    */


    private Lenkeliste<T> mindreEnnPivot( T pivot ) {
        Lenkeliste<T> mep = new Lenkeliste<T>();
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            T t = it.next();
            if ( t.compareTo(pivot) <= 0 ) {
                mep.settInnForan(t);
                it.remove();
            }
        }
        return mep;
    }

    public void limSammenForan ( Lenkeliste<T> ll ) {
        if ( ! ll.tom() ) {
                ll.bak.neste = lh.neste;
                lh.neste = ll.lh.neste;
        }
    }

    public void quickSort() {
	if (! tom() ) {
	    T pivot = this.taUtForan();
	    Lenkeliste<T> mep = mindreEnnPivot(pivot);
	    mep.quickSort();
	    this.quickSort();
	    this.settInnForan(pivot);
	    limSammenForan(mep);
	}
    }

    /* ************************************* */

    public void settInnForan(T o) {
        Node temp = new Node(o) ;
        // Hvis første node, er det «lanterne rouge» (baklykta)
        if (lh.neste == null) bak = temp;
        temp.neste = lh.neste ;
        lh.neste = temp ;
        //        System.out.println("Satt inn: " + o.toString());
    }

    public T taUtForan() {
        Node ut = lh.neste;
        lh.neste = lh.neste.neste;
        //        System.out.println("Tar ut: " + ut.data.toString());
        return ut.data;
    }

    public void skrivAlle() {
        Node iter = lh.neste;
        while ( iter != null ) {
            System.out.println(iter.data.toString());
            iter = iter.neste;
        }
    }

    public void skrivRek() { // bakerste først
        if (lh.neste != null) lh.neste.skriv();
    }
}
