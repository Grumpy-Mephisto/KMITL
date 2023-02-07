import java.util.*;

public class Lab5FunctionalInterface {
    static int[] arr = {28, 58, 8, 77, 48, 39};
    static ArrayProcessor q1NumberOfEvenElement; // 4
    static ArrayProcessor q2IndexOfLargestEvenValue; // 1
    static ArrayProcessor myMedian; // n/2th element of sorted = 48

    public static void main(String[] args) {
        q1(); // 4
        q2(); // 1
        oneline(); // 48
    }

    static void q1() {
        // Q1 Find number of even elements
        q1NumberOfEvenElement = (int[] arr) -> {
            int count = 0;
            for (int i : arr) {
                if(i % 2 == 0) count++;
            }
            return count;
        };
        System.out.println(q1NumberOfEvenElement.calculate(arr));
    }

    static void q2() {
        // Q2 Find index of largest even value
        q2IndexOfLargestEvenValue = (int[] arr) -> {
            int max = 0;
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] % 2 == 0 && arr[i] > max) {
                    max = arr[i];
                    index = i;
                }
            }
            return index;
        };
        System.out.println(q2IndexOfLargestEvenValue.calculate(arr));
    }

    static void oneline() {
        int[] tmp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(tmp);
        // Q3 Find median of sorted array
        myMedian = (int[] arr) -> arr[arr.length/2];
        System.out.println(myMedian.calculate(tmp));
    }
}