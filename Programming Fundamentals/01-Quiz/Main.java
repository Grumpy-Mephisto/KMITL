import java.util.*;

class Main {
    public static int Validation(int num, int min, int max) {
        try {
            if (num >= min && num <= max) {
                return num;
            }
        } catch (Exception e) {
            System.exit(0);
        }
        return num;
    }
    
    public static void main(String[] args) {
        int Row, Column, Sort;
        
        Scanner sc = new Scanner(System.in);

        Column = Validation(sc.nextInt(), 1, 1_000_000);
        Row = Validation(sc.nextInt(), 1, 1_000_000);
        int[][] arr = new int[Row][Column];

        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Column; j++) {
                arr[i][j] = Validation(sc.nextInt(), 1, 1_000_000);
            }
        }
            
        Sort = Validation(sc.nextInt(), 0, Column - 1);
        Arrays.sort(arr, (a, b) -> {
            if (a[Sort] == b[Sort]) {
                for (int i = 0; i < Column; i++) {
                    if (a[i] != b[i]) {
                        return a[i] - b[i];
                    }
                }
                return 0;
            }
            return a[Sort] - b[Sort];
        });

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == arr[i].length - 1) {
                    System.out.print(arr[i][j]);
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}