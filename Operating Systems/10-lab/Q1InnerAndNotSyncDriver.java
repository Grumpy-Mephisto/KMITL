public class Q1InnerAndNotSyncDriver {
    public static void main(String[] args) {
        int nThread = 100_000;
        SharedNum1 sn = new SharedNum1();
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
