public class Lab11_Q2Driver {
    public static void main(String[] args) {
        int numProducer = 2;
        int numConsumer = 15 * numProducer;
        Lab11_Q2Producer[] producers = new Lab11_Q2Producer[numProducer];
        Lab11_Q2Consumer[] consumers = new Lab11_Q2Consumer[numConsumer];
        Lab11_ApdxBlockingQueue<Element> syncQueue = new Lab11_ApdxBlockingQueue<Element>(10);

        for (int i = 0; i < numProducer; i++) {
            producers[i] = new Lab11_Q2Producer(i, syncQueue);
            producers[i].start();
        }

        for (int j = 2; j < numConsumer + 2; j++) {
            consumers[j - 2] = new Lab11_Q2Consumer(j, syncQueue);
            consumers[j - 2].start();
        }

        try {
            for (int i = 0; i < numProducer; i++) {
                producers[i].join();
            }
        } catch (InterruptedException e) {
            System.out.println("Producer interrupted");
        }

        try {
            for (int j = 2; j < numConsumer + 2; j++) {
                consumers[j - 2].join();
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted");
        }

        for (int i = 0; i < numProducer; i++) {
            System.out.println(
                    "Producer " + producers[i].id + " produced " + producers[i].numCook + " items");
        }
        System.out.println("Bye");
    }
}
