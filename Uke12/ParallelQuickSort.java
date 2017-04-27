import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;


class ParallelQuickSort<T extends Comparable<T>> {
    private T[] list;
    private final int antTraader;
    private final int elementerPerTraad;
    private final ExecutorService executor;
    private final Lock lock = new ReentrantLock();
    private final Condition alleFerdig = lock.newCondition();

    private int antAktiveTraader = 0;

    public ParallelQuickSort(T[] list, int antTraader) {
        this.list = list;
        this.antTraader = antTraader;
        elementerPerTraad = list.length / antTraader;
        executor = Executors.newFixedThreadPool(antTraader);
    }

    public void sort() {
        executor.execute(new SorterEnDel(0, list.length-1));
        lock.lock();
        try {
            while(antAktiveTraader > 0) {
                // her blir låsen låst opp
                alleFerdig.await();
            }
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        } finally {
            lock.unlock();
        }
    }

    class SorterEnDel implements Runnable {
        private int fraIndex, tilIndex;

        public SorterEnDel(int fraIndex, int tilIndex) {
            this.fraIndex = fraIndex;
            this.tilIndex = tilIndex;
            lock.lock();
            try {
                antAktiveTraader++;
            } finally {
                lock.unlock();
            }
        }

        public void run() {
            quicksort(fraIndex, tilIndex);

            lock.lock();
            try{
                antAktiveTraader--;
                if(antAktiveTraader == 0) {
                    alleFerdig.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    private void quicksort(int lav, int hoy) {
        if(hoy - lav < 1) return;

        int i = lav;
        int j = hoy;

        T pivot = list[(i+j)/2];

        while(i <= j) {
            while(list[i].compareTo(pivot) < 0) {
                i++;
            }

            while(list[j].compareTo(pivot) > 0) {
                j--;
            }

            if(i <= j) {
                bytt(i, j);
                i++;
                j--;
            }
        }

        // sortere de lave
        if(j - lav > elementerPerTraad) {
            executor.execute(new SorterEnDel(lav, j));
        } else if(j - lav > 0) {
            quicksort(lav, j);
        }

        // sortere de høye
        if(hoy - i > elementerPerTraad) {
            executor.execute(new SorterEnDel(i, hoy));
        } else if(hoy - i > 0) {
            quicksort(i, hoy);
        }

    }

    private void bytt(int i, int j) {
        T tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }
}
