public class Popper extends Thread {
    public int turns;
    public StackForConcurrent stack;

    public Popper(int turns, StackForConcurrent stack) {
        this.turns = turns;
        this.stack = stack;
    }

    public void run() {
        int i = -1;
        for (int j = 0; j < turns; j++) {
            i = stack.pop();
            System.out.println("Popper " + i + " popped " + stack.size + " items");
        }
    }
}
