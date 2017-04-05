import java.util.Iterator;
class Sorterer<T extends Comparable<T>> {
    Lenkeliste<T> liste;

    public Sorterer(Lenkeliste<T> liste) {
        this.liste = liste;
    }

    public void sorter() {
        rek_quicksort(liste);
    }

    private void rek_quicksort(Lenkeliste<T> skalSorteres) {
        if(!skalSorteres.tom()) {
            T pivot = skalSorteres.taUtForan();
            Lenkeliste ny = mindreEnnPivot(pivot, skalSorteres);
            rek_quicksort(ny);
            rek_quicksort(skalSorteres);
            skalSorteres.settInnForan(pivot);
            limSammenForan(ny, skalSorteres);
        }
    }

    private Lenkeliste<T> mindreEnnPivot(T pivot, Lenkeliste<T> skalSorteres) {
        Lenkeliste<T> ny = new Lenkeliste<T>();
        Iterator<T> it = skalSorteres.iterator();
        while(it.hasNext()) {
            T t = it.next();
            if(t.compareTo(pivot) <= 0) {
                ny.settInnForan(t);
                it.remove();
            }
        }
        return ny;
    }

    private void limSammenForan(Lenkeliste<T> l1, Lenkeliste<T> l2) {
        l2.limSammenForan(l1);
    }
}
