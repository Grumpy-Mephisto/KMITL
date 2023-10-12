public class Lab11_Q2Consumer extends Thread {
    public int id;
    protected Lab11_ApdxBlockingQueue<Element> queue;

    public Lab11_Q2Consumer(int id, Lab11_ApdxBlockingQueue<Element> queue) {
        this.id = id;
        this.queue = queue;
    }

    public void run() {
        try {
            Element e = queue.take();
            System.out.println("Consumer " + id + " consumed " + e.val + " items");
        } catch (InterruptedException e) {
            System.out.println("Consumer " + id + " interrupted");
        }
    }
}
