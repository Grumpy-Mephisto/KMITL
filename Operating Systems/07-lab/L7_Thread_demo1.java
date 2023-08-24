public class L7_Thread_demo1 {
    public static void main(String[] args) {
        L7_Obj x = new L7_Obj();
        Thread t1 = new Thread(new WorkerDemo1(x));
        t1.start();
        Thread t2 = new Thread(new WorkerDemo2(x));
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}


class L7_Obj {
    private int value;

    public L7_Obj() {
        value = 0;
    }

    public void inc(int x) {
        value += x;
    }

    public int getValue() {
        return value;
    }
}


class WorkerDemo1 implements Runnable {
    private L7_Obj o;

    public WorkerDemo1(L7_Obj y) {
        o = y;
    }

    public void run() {
        // o.inc(3);
        System.out.println("From WorkerDemo1 " + Thread.currentThread().getId() + " x value is "
                + o.getValue()); // o.getValue() is equal 0, but if uncomment o.inc(3), it will be 3
    }
}


class WorkerDemo2 implements Runnable {
    private L7_Obj o;

    public WorkerDemo2(L7_Obj y) {
        o = y;
    }

    public void run() {
        o.inc(4);
        System.out.println("From WorkerDemo2 " + Thread.currentThread().getId() + " x value is "
                + o.getValue());
    }
}
