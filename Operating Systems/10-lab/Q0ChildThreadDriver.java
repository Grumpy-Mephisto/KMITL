public class Q0ChildThreadDriver {
    public static void main(String[] args) {
        int nThread = 100_000;
        SharedNum1 sn = new SharedNum1();
        Thread[] thr = new Thread[nThread];

        for (int i = 0; i < nThread; i++) { // สร้าง thread 100,000 ตัว
            thr[i] = new ChildSimple(sn); // แต่ละตัวมี reference ไปยัง object ของ SharedNum1
            thr[i].start(); // สั่งให้ thread ทำงาน
        }

        for (int i = 0; i < nThread; i++) {
            try {
                thr[i].join(); // รอให้ thread ทำงานเสร็จ
            } catch (InterruptedException e) {
                e.printStackTrace(); // แสดง stack trace กรณีมี error
            }
        }

        if (sn.getVal() < nThread) { // ต้องได้ค่า 100,000 ถึงถูก
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
