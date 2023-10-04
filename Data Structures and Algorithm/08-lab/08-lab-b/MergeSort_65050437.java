import java.util.Arrays;

public class MergeSort_65050437 {
    public static void main(String[] args) {
        demo1();
        demo2_descending();
        demo3_multi_key();
    }

    public static void demo1() {
        System.out.println("===== Demo 1 =====");

        int[] arr = {8, 3, 2, 9, 7, 1, 4};
        MergeSort.m_sort(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    public static void demo2_descending() {
        System.out.println("===== Demo 2 Descending =====");

        int[][] arr = {{11, 88}, {33, 99}, {22, 77}};
        MergeSort.m_sort(arr, 0);
        for (int row = 0; row < arr.length; row++) {
            System.out.println(Arrays.toString(arr[row]));
        }
    }

    public static void demo3_multi_key() {
        System.out.println("===== Demo 3 Multi Key =====");

        int[][] arr = {{11, 22, 33, 44}, {19, 17, 63, 57}, {17, 22, 18, 15}, {12, 18, 73, 84},
                {14, 27, 33, 55}};
        MergeSort.m_sort(arr, 1, 2, 0);
        for (int row = 0; row < arr.length; row++) {
            System.out.println(Arrays.toString(arr[row]));
        }
    }

    static class MergeSort {
        /**
         * Merge Sort for Demo 1
         * 
         * @param arr array
         * @param pass pass number
         */
        public static void m_sort(int[] arr, int pass) {
            int size = arr.length;

            if (size <= 1) {
                return;
            }

            int mid = size / 2;
            int[] left = new int[mid];
            int[] right = new int[size - mid];

            for (int i = 0; i < mid; i++) {
                left[i] = arr[i];
            }

            for (int i = mid; i < size; i++) {
                right[i - mid] = arr[i];
            }

            m_sort(left, pass);
            m_sort(right, pass + mid);

            merge(arr, left, right);
        }

        /**
         * Merge for Demo 1
         * 
         * @param arr array
         * @param left left array
         * @param right right array
         */
        public static void merge(int[] arr, int[] left, int[] right) {
            int sizeLeft = left.length;
            int sizeRight = right.length;
            int i = 0, j = 0, k = 0;

            while (i < sizeLeft && j < sizeRight) {
                if (left[i] <= right[j]) {
                    arr[k++] = left[i++];
                } else {
                    arr[k++] = right[j++];
                }
            }

            while (i < sizeLeft) {
                arr[k++] = left[i++];
            }

            while (j < sizeRight) {
                arr[k++] = right[j++];
            }
        }

        /**
         * Merge Sort for Demo 2
         * 
         * @param arr array
         * @param pass pass number
         */
        public static void m_sort(int[][] arr, int pass) {
            int size = arr.length;

            if (size <= 1) {
                return;
            }

            int mid = size / 2;
            int[][] left = new int[mid][2];
            int[][] right = new int[size - mid][2];

            for (int i = 0; i < mid; i++) {
                left[i] = arr[i];
            }

            for (int i = mid; i < size; i++) {
                right[i - mid] = arr[i];
            }

            m_sort(left, pass);
            m_sort(right, pass + mid);

            merge(arr, left, right);
        }

        /**
         * Merge for Demo 2
         * 
         * @param arr array
         * @param left left array
         * @param right right array
         */
        public static void merge(int[][] arr, int[][] left, int[][] right) {
            int sizeLeft = left.length;
            int sizeRight = right.length;
            int i = 0, j = 0, k = 0;

            while (i < sizeLeft && j < sizeRight) {
                if (left[i][0] >= right[j][0]) {
                    arr[k++] = left[i++];
                } else {
                    arr[k++] = right[j++];
                }
            }

            while (i < sizeLeft) {
                arr[k++] = left[i++];
            }

            while (j < sizeRight) {
                arr[k++] = right[j++];
            }
        }

        /**
         * Merge Sort for Demo 3
         * 
         * @param arr array
         * @param key1 key number 1
         * @param key2 key number 2
         * @param pass pass number
         */
        public static void m_sort(int[][] arr, int key1, int key2, int pass) {
            int size = arr.length;
            int sizeCol = arr[0].length;

            if (size <= 1 || sizeCol <= 1) {
                return;
            }

            int mid = size / 2;
            int[][] left = new int[mid][sizeCol];
            int[][] right = new int[size - mid][sizeCol];

            for (int i = 0; i < mid; i++) {
                left[i] = arr[i];
            }

            for (int i = mid; i < size; i++) {
                right[i - mid] = arr[i];
            }

            m_sort(left, key1, key2, pass);
            m_sort(right, key1, key2, pass + mid);

            merge(arr, left, right, key1, key2);
        }

        /**
         * Merge for Demo 3
         * 
         * @param arr array
         * @param left left array
         * @param right right array
         * @param key1 key number 1
         * @param key2 key number 2
         */
        public static void merge(int[][] arr, int[][] left, int[][] right, int key1, int key2) {
            int sizeLeft = left.length;
            int sizeRight = right.length;
            int i = 0, j = 0, k = 0;

            while (i < sizeLeft && j < sizeRight) {
                if (left[i][key1] > right[j][key1]
                        || (left[i][key1] == right[j][key1] && left[i][key2] > right[j][key2])) {
                    arr[k++] = left[i++];
                } else {
                    arr[k++] = right[j++];
                }
            }

            while (i < sizeLeft) {
                arr[k++] = left[i++];
            }

            while (j < sizeRight) {
                arr[k++] = right[j++];
            }
        }
    }
}
