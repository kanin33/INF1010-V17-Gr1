import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Teller implements Runnable {
    private TelleMonitor monitor;
    public Teller(TelleMonitor monitor) {
        this.monitor = monitor;
    }
    public void run() {
        for(int i=0; i<10000000; i++) {
            monitor.increase();
        }
        System.out.println(monitor.getFellesTeller());
    }
}
