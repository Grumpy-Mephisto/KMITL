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

// Explanation of differences between isPrime methods:

// isPrime0 is the slowest because it performs redundant checks, for example, 
// it checks numbers up to n/2 for divisibility, even though the loop will terminate earlier.
// isPrime0 ช้าที่สุดเนื่องจากมีการทำซ้ำในการตรวจสอบ ยกตัวอย่างเช่น ตัวเลข 4 จะถูกหารด้วย 2 และ 4 ทำให้มีการทำซ้ำซ้อน

// isPrime1 is faster than isPrime0 as it uses the square root of n as the loop boundary, 
// reducing the number of iterations. However, it still includes some unnecessary checks.
// isPrime1 เร็วกว่า isPrime0 เนื่องจากใช้ขอบเขตของลูปเป็นรากที่สองของ n ลดจำนวนการทำซ้ำ แต่ยังคงมีการทำซ้ำบางส่วน

// isPrime2 is the fastest because it optimizes the algorithm further. It skips divisibility 
// checks for even numbers (except for 2) and checks odd numbers only up to the square root of n.
// This avoids redundant checks and leads to improved performance.
// isPrime2 เร็วที่สุดเนื่องจากปรับปรุงอัลกอริทึมให้มากขึ้น ข้ามการตรวจสอบความหารของเลขคู่ (ยกเว้น 2) 
// และตรวจสอบเลขคี่เพียงรากที่สองของ n เท่านั้น ไม่มีการทำซ้ำซ้อน ซึ่งเป็นเหตุผลที่ทำให้เร็วกว่า