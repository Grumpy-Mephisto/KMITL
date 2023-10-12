public class Lab11_Q3DriverSol {
    public static void main(String[] args) {
        int numPopper = 1, numPusher = 1;
        int numTurns = 10;
        StackForConcurrent stack = new StackForConcurrent();
        Pusher[] pushArr = new Pusher[numPusher];
        Popper[] popArr = new Popper[numPopper];

        for (int i = 0; i < numPusher; i++) {
            pushArr[i] = new Pusher(numTurns, stack);
            popArr[i] = new Popper(numTurns, stack);
            pushArr[i].start();
            popArr[i].start();
        }

        for (int i = 0; i < numPusher; i++) {
            try {
                pushArr[i].join();
                popArr[i].join();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }
}
