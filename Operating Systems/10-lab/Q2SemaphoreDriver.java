import java.util.concurrent.Semaphore;

public class Q2SemaphoreDriver {
    public static void main(String[] args) {
        int nThread = 100_000;
        SharedNum2 sn = new SharedNum2();
        int v = 2;
        // SharedNum2 sn = new SharedNum3();
        // int v = 3;
        // SharedNum2 sn = new SharedNum4();
        // int v = 4;
        Thread[] thr = new Thread[nThread];
        for (int i = 0; i < nThread; i++) {
            thr[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    sn.increment();
                }
            });
            thr[i].start();
        }

        for (int i = 0; i < nThread; i++) {
            try {
                thr[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (sn.getVal() < nThread) {
            System.out.printf("value 0 = %d Not 100,000\n", sn.getVal());
        } else {
            System.out.printf("value 0 = %d OK\n", sn.getVal());
        }
    }
}


/**
 * Semaphone Method
 */
class SharedNum2 {
    private int val = 0;
    Semaphore mutex;

    public SharedNum2() {
        val = 0;
        mutex = new Semaphore(1);
    }

    public void increment() {
        try {
            mutex.acquire();
            val++;
            mutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getVal() {
        return val;
    }
}


/**
 * Synchronized Method
 */
class SharedNum3 {
    private int val = 0;

    public SharedNum3() {
        val = 0;
    }

    public synchronized void increment() {
        val++;
    }

    public int getVal() {
        return val;
    }
}


/**
 * Synchronized Block
 */
class SharedNum4 {
    private int val = 0;

    public void increment() {
        synchronized (this) {
            val++;
        }
    }

    public int getVal() {
        return val;
    }
}
