// må importere Iterator, men ikke Iterable
import java.util.Iterator;

/**
 * Itererbar beholder med array som grunnstuktur
 */
class EnkelArrayListe<E> implements Iterable<E> {
    E[] array;
    int antElementer;
    int storrelse;

    public EnkelArrayListe(int storrelse) {
        this.storrelse = storrelse;
        // dette er en 'hack' som gjør at vi kan
        // lage en generisk array
        //
        // det går ikke an å skrive
        // new E[storrelse]
        array = (E[]) new Object[storrelse];
    }

    public boolean leggInn(E e) {
        // hvis arrayet er fullt går det ikke an å legge
        // inn mer
        if(antElementer == storrelse) {
            return false;
        } else {
            // sett inn på neste ledige plass
            array[antElementer] = e;
            antElementer++;
            return true;
        }
    }

    // dette er en klasse som beksriver en iterator
    // for *denne* klassen
    // Iterator-klasser må implementere Iterator-interfacet
    private class EnkelIterator implements Iterator<E> {
        // indexen iteratoren er på nå
        int her = 0;

        @Override
        public boolean hasNext() {
            // det finnes en neste så lenge neste element
            // ikke er null og vi ikke er på slutten av
            // arrayet
            if(array[her+1] != null && (her+1) < storrelse) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public E next() {
            return array[her+1];
        }
    }

    @Override
    public Iterator<E> iterator() {
        // denne metoden må vi implementere siden klassen
        // implementerer Iterable
        return new EnkelIterator();
    }
}
