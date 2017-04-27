
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class TelleMonitor {
    private int fellesTeller;
    private Lock lock;
    public TelleMonitor() {
        lock = new ReentrantLock();
    }

    public void increase() {
        lock.lock();
        try {
            fellesTeller++;
        } finally {
            lock.unlock();
        }
    }

    public int getFellesTeller() {
        return fellesTeller;
    }
}
