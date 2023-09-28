public class Q5WaitNotifyDriver {
    public static void main(String[] args) {
        SharedNum5 sn = new SharedNum5();
        (new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.printf("You got it %d\n", sn.getVal());
            }
        })).start();

        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        (new Thread(new Runnable() {
            @Override
            public void run() {
                sn.setVal(2021);
            }
        })).start();

        System.out.println("From main thread");
    }
}


class SharedNum5 {
    private int val = 0;
    Object lock;

    public SharedNum5() {
        val = 0;
        lock = new Object();
    }

    public int getVal() {
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return val;
        }
    }

    public void setVal(int v) {
        synchronized (lock) {
            val = v;
            lock.notifyAll();
        }
    }
}
