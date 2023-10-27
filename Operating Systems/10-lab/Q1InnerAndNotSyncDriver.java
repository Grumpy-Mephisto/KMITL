public class Q1InnerAndNotSyncDriver {
    public static void main(String[] args) {
        int nThread = 100_000;
        SharedNum1 sn = new SharedNum1();
        Thread[] thr = new Thread[nThread];

        for (int i = 0; i < nThread; i++) { // สร้าง thread 100,000 ตัว
            thr[i] = new Thread(new Runnable() { // สร้าง thread แบบ anonymous inner class
                @Override
                public void run() {
                    sn.increment();
                }
            });
            thr[i].start(); // สั่งให้ thread ทำงาน
        }

        for (int i = 0; i < nThread; i++) {
            try {
                thr[i].join(); // รอให้ thread ทำงานเสร็จ
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
