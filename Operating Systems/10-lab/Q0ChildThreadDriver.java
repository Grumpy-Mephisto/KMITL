public class Q0ChildThreadDriver {
    public static void main(String[] args) {
        int nThread = 100_000;
        SharedNum1 sn = new SharedNum1();
        Thread[] thr = new Thread[nThread];

        for (int i = 0; i < nThread; i++) {
            thr[i] = new ChildSimple(sn);
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


class SharedNum1 {
    private int val = 0;

    public void increment() {
        val++;
    }

    public int getVal() {
        return val;
    }
}


class ChildSimple extends Thread {
    SharedNum1 resource;

    public ChildSimple(SharedNum1 ref) {
        resource = ref;
    }

    public void run() {
        resource.increment();
    }
}
