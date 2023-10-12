public class Lab11_Q2Producer extends Thread {
    public int id;
    public int numCook = 0;
    protected Lab11_ApdxBlockingQueue<Element> queue;

    public Lab11_Q2Producer(int id, Lab11_ApdxBlockingQueue<Element> queue) {
        this.id = id;
        this.queue = queue;
    }

    public void run() {
        if (id % 2 == 0) {
            int i = -1;
            while (i < 30) {
                i += 2;
                try {
                    queue.put(new Element(1));
                    numCook++;
                    System.out.println("Producer " + id + " produced " + queue.size() + " items");
                } catch (InterruptedException e) {
                    System.out.println("Cheif " + id + " interrupted");
                }
            }
        } else {
            int i = 0;
            while (i < 29) {
                i += 2;
                try {
                    queue.put(new Element(1));
                    numCook++;
                    System.out.println("Producer " + id + " produced " + queue.size() + " items");
                } catch (InterruptedException e) {
                    System.out.println("Diner " + id + " interrupted");
                }
            }
        }
    }
}
