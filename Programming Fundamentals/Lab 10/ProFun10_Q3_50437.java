import java.util.*;

class ProFun10_Q3_50437 {
    public static int index = 0;

    public static int[] negativesToZero(int[] a) {
        if (index > a.length - 1) return a;
        if (a[index] < 0) {
            a[index] = 0;
        }
        
        index += 1;
        return negativesToZero(a);
    }

    public static void main(String[] args) {
        int[] arr = {1,-2, 3, 4, -5};
        System.out.println(Arrays.toString(negativesToZero(arr)));
    }
}
