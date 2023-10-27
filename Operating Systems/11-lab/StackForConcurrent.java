public class StackForConcurrent {
    public Node top;
    public int size;

    public StackForConcurrent() {
        top = null;
        size = 0;
    }

    public synchronized void push(int i) { // ถ้าเป็น public void push(int i) จะเกิด deadlock ได้
        top = new Node(i, top);
        size++;
        if (top.next == null) {
            /*
             * Q1
             */
            notifyAll(); // ถ้าเป็น notify() จะเกิด deadlock ได้
        }
    }

    /*
     * Q2
     */
    public synchronized int pop() { // ถ้าเป็น public int pop() จะเกิด deadlock ได้
        try {
            while (top == null) {
                System.out.println("Empty stack, waiting...");
                /*
                 * Q3
                 */
                wait(); // ถ้าเป็น notify() จะเกิด deadlock ได้
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
