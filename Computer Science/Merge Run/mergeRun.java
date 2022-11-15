import java.util.Arrays;

public class Lab10_50437 {

  public static void main(String[] args) {
    int[] arr = {
      2,
      4,
      6,
      15,
      7,
      10,
      13,
      18,
      3,
      20,
      21,
      23,
      1,
      5,
      8,
      22,
      32,
      34,
      36,
      315,
      37,
      310,
      313,
      318,
      33,
      320,
      321,
      323,
      31,
      35,
      38,
      322,
    };
    mergeRun(arr, 3, 2);
  }

  static void mergeRun(int[] x, int p, int q) {
    int[] ab = new int[x.length];
    while (p != 0) {
      for (int a = 0; a < (int) Math.pow(2, p) / 2; a++) {
        int multiply = a * (int) Math.pow(2, q) * 2;
        int firstSetLength = multiply + (int) (Math.pow(2, q));
        int lastSetLength = multiply + (int) (Math.pow(2, q)) * 2;
        int[] left = Arrays.copyOfRange(
          x,
          0 + (a * (int) (Math.pow(2, q)) * 2),
          firstSetLength
        );

        int[] right = Arrays.copyOfRange(x, firstSetLength, lastSetLength);

        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
          if (left[i] <= right[j]) {
            ab[multiply + k++] = left[i++];
          } else {
            ab[multiply + k++] = right[j++];
          }
        }
        while (i < left.length) {
          ab[multiply + k++] = left[i++];
        }
        while (j < right.length) {
          ab[multiply + k++] = right[j++];
        }
      }
      x = ab;
      p -= 1;
      q += 1;
    }
    System.out.println("array " + Arrays.toString(ab));
  }
}
