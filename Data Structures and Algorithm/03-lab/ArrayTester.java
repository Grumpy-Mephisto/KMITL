public class ArrayTester {
  public static void main(String args[]) {
    int numRounds = 5;
    int numNValues = 10; // Step size of N

    long[][] timeKeeper = new long[numRounds][numNValues];

    for (int round = 0; round < numRounds; round++) {
      System.out.printf("--------- Round %d ---------\n", round + 1);
      for (int i = 0, N = 10_000_000; i < numNValues; i++, N += 10_000_000) {
        long time = measureArrayCreationTime(N);
        timeKeeper[round][i] = time;
        System.out.printf("Round %d: N = %,d \tTime = %,d ms\n", round + 1, N,
                          time);
      }
      System.out.println();
    }

    for (int i = 0, N = 10_000_000; i < numNValues; i++, N += 10_000_000) {
      long totalNTime = 0;
      for (int round = 0; round < numRounds; round++) {
        totalNTime += timeKeeper[round][i];
      }
      float averageNTime = (float)totalNTime / numRounds;
      float averageTimePerN = averageNTime / N;
      System.out.printf(
          "Average time for N = %,d \tTime = %,.2f ms \tAverage time per N = %.8f ms\n",
          N, averageNTime, averageTimePerN);
    }
  }

  private static long measureArrayCreationTime(int N) {
    long start = System.currentTimeMillis();
    MyArray mArray = new MyArray();
    for (int n = 1; n < N; n++) {
      mArray.add((int)(Math.random() * 1000));
    }
    return System.currentTimeMillis() - start;
  }
}
