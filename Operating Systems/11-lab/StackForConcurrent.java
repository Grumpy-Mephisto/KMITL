public class StackForConcurrent {
    public Node top;
    public int size;

    public StackForConcurrent() {
        top = null;
        size = 0;
    }

    public synchronized void push(int i) {
        top = new Node(i, top);
        size++;
        if (top.next == null) {
            /*
             * Q1
             */
            notifyAll();
        }
    }

    /*
     * Q2
     */
    public synchronized int pop() {
        try {
            while (top == null) {
                System.out.println("Empty stack, waiting...");
                /*
                 * Q3
                 */
                wait();
            }
            /*
             * Q4.1
             */
            // size--;
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
            return 1;
        }
        /*
         * Q4.2
         */
        size--;
        int val = top.val;
        top = top.next;
        return val;
    }
}
