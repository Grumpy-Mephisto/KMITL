import java.util.Random;

public class Pusher extends Thread {
    public int turns;
    public StackForConcurrent stack;

    public Pusher(int turns, StackForConcurrent stack) {
        this.turns = turns;
        this.stack = stack;
    }

    /*
     * Q5
     */
    public void run() {
        Random random = new Random();
        try {
            sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        for (int i = 0; i < turns; i++) {
            stack.push(i);
        }
    }
}
