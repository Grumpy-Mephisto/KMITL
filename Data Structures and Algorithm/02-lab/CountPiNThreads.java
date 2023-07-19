import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CountPiNThreads {

  static boolean isPrime0(int n) {
    if (n == 1) return false;
    if (n <= 3) return true;

    int m = n / 2;
    for (int i = 2; i <= m; i++) {
      if (n % i == 0) return false;
    }
    return true;
  }

  static boolean isPrime1(int n) {
    if (n == 1) return false;
    if (n <= 3) return true;

    int m = (int) Math.sqrt(n);
    for (int i = 2; i <= m; i++) {
      if (n % i == 0) return false;
    }
    return true;
  }

  static boolean isPrime2(int n) {
    if (n == 1) return false;
    if (n <= 3) return true;

    if (n % 2 == 0 || n % 3 == 0) return false;
    int m = (int) Math.sqrt(n);
    for (int i = 3; i <= m; i += 2) {
      if (n % i == 0) return false;
      if (n % (i + 2) == 0) return false;
    }
    return true;
  }

  static class Worker implements Runnable {

    private final int start;
    private final int end;
    private final int method;
    private final AtomicInteger count;

    public Worker(int start, int end, int method, AtomicInteger count) {
      this.start = start;
      this.end = end;
      this.method = method;
      this.count = count;
    }

    @Override
    public void run() {
      int localCount = 0;
      for (int n = start; n < end; n++) {
        switch (method) {
          case 0:
            if (isPrime0(n)) localCount++;
            break;
          case 1:
            if (isPrime1(n)) localCount++;
            break;
          case 2:
            if (isPrime2(n)) localCount++;
            break;
        }
      }
      count.addAndGet(localCount);
    }
  }

  public static void main(String[] args) {
    System.out.println("---------------------------------------------------");
    System.out.println("Prime Number Counting Program: Execution Statistics");
    System.out.println("---------------------------------------------------");

    int numThreads = 6;

    for (int method = 0; method <= 2; method++) {
      System.out.println("Method: isPrime" + method);
      System.out.println("N \t\tCount \t\tTime (ms)");

      for (int N = 100_000; N <= 1_000_000; N += 100_000) {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        int finalN = N;
        long start = System.currentTimeMillis();
        AtomicInteger count = new AtomicInteger(0);

        int chunkSize = N / numThreads;
        for (int i = 0; i < numThreads; i++) {
          int startValue = i * chunkSize + 1;
          int endValue = (i == numThreads - 1) ? finalN : (i + 1) * chunkSize;

          Runnable worker = new Worker(startValue, endValue, method, count);
          executor.execute(worker);
        }

        executor.shutdown();
        try {
          executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        long time = System.currentTimeMillis() - start;
        System.out.printf("%,d \t%,d \t\t%,d\n", N, count.get(), time);
      }
      System.out.println();
    }

    System.out.println("---------------------------------------------------");
  }
}
