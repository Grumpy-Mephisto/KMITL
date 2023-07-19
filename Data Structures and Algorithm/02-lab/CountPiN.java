import java.text.DecimalFormat;

public class CountPiN {

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

  public static void main(String[] args) {
    System.out.println("---------------------------------------------------");
    System.out.println("Prime Number Counting Program: Execution Statistics");
    System.out.println("---------------------------------------------------");

    System.out.println("Method: isPrime0");
    System.out.println("N \t\tCount \t\tTime (ms)");
    for (int N = 100_000; N <= 1_000_000; N += 100_000) {
      long start = System.currentTimeMillis();
      int count = 0;
      for (int n = 1; n < N; n++) {
        if (isPrime0(n)) count++;
      }
      long time = System.currentTimeMillis() - start;
      System.out.printf("%,d \t%,d \t\t%,d\n", N, count, time);
    }
    System.out.println();

    System.out.println("Method: isPrime1");
    System.out.println("N \t\tCount \t\tTime (ms)");
    for (int N = 100_000; N <= 1_000_000; N += 100_000) {
      long start = System.currentTimeMillis();
      int count = 0;
      for (int n = 1; n < N; n++) {
        if (isPrime1(n)) count++;
      }
      long time = System.currentTimeMillis() - start;
      System.out.printf("%,d \t%,d \t\t%,d\n", N, count, time);
    }
    System.out.println();

    System.out.println("Method: isPrime2");
    System.out.println("N \t\tCount \t\tTime (ms)");
    for (int N = 100_000; N <= 1_000_000; N += 100_000) {
      long start = System.currentTimeMillis();
      int count = 0;
      for (int n = 1; n < N; n++) {
        if (isPrime2(n)) count++;
      }
      long time = System.currentTimeMillis() - start;
      System.out.printf("%,d \t%,d \t\t%,d\n", N, count, time);
    }
    System.out.println("---------------------------------------------------");
  }
}
