import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Lab11_ApdxBlockingQueue<E> {
    private final Object[] items;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private int putPointer, takePointer, curSize;

    /**
     * สร้าง queue ที่มีความจุ capacity
     * 
     * @param capacity ความจุของ queue
     */
    public Lab11_ApdxBlockingQueue(int capacity) {
        items = new Object[capacity];
    }

    /**
     * เพิ่มข้อมูลใน queue
     * 
     * @param value ข้อมูลที่จะใส่ใน queue
     * @throws InterruptedException ถ้ามีการ interrupt ในขณะที่รอ
     */
    public void put(E value) throws InterruptedException {
        lock.lock(); // รอให้มีสถานะ lock
        try {
            while (curSize == items.length) {
                System.out.println("Queue is full, waiting...");
                notFull.await(); // รอให้มีสถานะ notFull
                System.out.println("Queue is not full, continue...");
            }
            items[putPointer++] = value;
            if (putPointer == items.length) {
                putPointer = 0;
            }
            synchronized (items) { // ไม่ต้องใส่ synchronized ก็ได้
                                   // แต่เพื่อให้เห็นว่ามีการเปลี่ยนแปลงค่าของ curSize
                curSize++;
            }
            notEmpty.signalAll(); // ส่ง signal ไปที่ทุก thread ที่รออยู่ที่ notEmpty
        } finally {
            lock.unlock(); // ปลด lock
        }
    }

    /**
     * นำข้อมูลออกจาก queue
     * 
     * @return ข้อมูลที่ออกจาก queue
     * @throws InterruptedException ถ้ามีการ interrupt ในขณะที่รอ
     */
    public E take() throws InterruptedException {
        lock.lock(); // รอให้มีสถานะ lock
        try {
            while (curSize == 0) {
                System.out.println("Queue is empty, waiting...");
                notEmpty.await(); // รอให้มีสถานะ notEmpty
                System.out.println("Queue is not empty, continue...");
            }
            @SuppressWarnings("unchecked")
            E value = (E) items[takePointer++];
            if (takePointer == items.length) {
                takePointer = 0;
            }
            synchronized (items) { // ไม่ต้องใส่ synchronized ก็ได้
                                   // แต่เพื่อให้เห็นว่ามีการเปลี่ยนแปลงค่าของ curSize
                curSize--;
            }
            notFull.signalAll();
            return value;
        } finally {
            lock.unlock(); // ปลด lock
        }
    }

    public int size() {
        return curSize;
    }
}
