public class Lab11_Q3DriverSol {
    public static void main(String[] args) {
        int numPopper = 1, numPusher = 1;
        int numTurns = 10;
        StackForConcurrent stack = new StackForConcurrent();
        Pusher[] pushArr = new Pusher[numPusher]; // สร้าง array ของ Pusher
        Popper[] popArr = new Popper[numPopper]; // สร้าง array ของ Popper
        // Pusher คือ thread ที่จะ push ข้อมูลเข้า stack
        // Popper คือ thread ที่จะ pop ข้อมูลออกจาก stack

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
