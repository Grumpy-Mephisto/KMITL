import java.util.Arrays;

public class Lab7MaxSquareAndEditDistance {
    private static int rows;
    private static int cols;
    private static int[][] matrix;
    private static int maxSquareSize = -1;

    public static void main(String[] args) {
        matrix = new int[][] {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}, {0, 1, 1, 1, 1}, {1, 1, 1, 1, 0}};
        System.out.println("Maximum Square Size: " + findMaxSquareSize(matrix));

        int[][] data = new int[][] {{0, 1, 1, 0, 1}, {1, 1, 0, 1, 0}, {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}};
        System.out.println("Maximum Size Square Submatrix: " + findMaxSquareSubmatrix(data));

        String str1 = "fuorf";
        String str2 = "fives";
        System.out.println("Edit Distance: " + calculateEditDistance(str1, str2));
    }

    /**
     * Question 1.1 หาค่าที่มากที่สุดใน matrix ที่เป็น square
     * 
     * @param matrix the matrix
     * @return the maximum square size
     */
    public static int findMaxSquareSize(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        calculateMaxSquareSize(0, 0);
        return maxSquareSize * maxSquareSize;
    }

    private static int calculateMaxSquareSize(int r, int c) {
        if (r == rows || c == cols) {
            return 0;
        }

        int right = calculateMaxSquareSize(r, c + 1);
        int down = calculateMaxSquareSize(r + 1, c);
        int diagonal = calculateMaxSquareSize(r + 1, c + 1);

        int size = 1 + Math.min(right, Math.min(down, diagonal));

        if (right > 0 && down > 0 && diagonal > 0 && matrix[r][c] > 0)
            matrix[r][c] = size;

        if (matrix[r][c] == 0)
            return 0;

        maxSquareSize = Math.max(size, maxSquareSize);
        return size;
    }

    /**
     * Question 1.2 หา square submatrix ที่มีขนาดมากที่สุด submatrix คือ matrix ที่อยู่ใน matrix
     * 
     * @param data the matrix
     * @return the maximum size square submatrix
     */
    public static int findMaxSquareSubmatrix(int[][] data) {
        int row = data.length;
        int col = data[0].length;

        int[][] sub = new int[row][col];

        for (int i = 0; i < col; i++) {
            sub[0][i] = data[0][i];
        }

        for (int i = 0; i < row; i++) {
            sub[i][0] = data[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (data[i][j] == 1) {
                    sub[i][j] =
                            Math.min(sub[i - 1][j - 1], Math.min(sub[i][j - 1], sub[i - 1][j])) + 1;
                } else {
                    sub[i][j] = 0;
                }
            }
        }

        int maxSize = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (sub[i][j] > maxSize) {
                    maxSize = sub[i][j];
                }
            }
        }

        return maxSize;
    }

    /**
     * Question 2 คำนวณ edit distance ของ 2 string
     * 
     * @param str1 first string
     * @param str2 second string
     * @return the edit distance
     */
    public static int calculateEditDistance(String str1, String str2) {
        int[][] cache = new int[str1.length() + 1][str2.length() + 1];

        for (int[] row : cache)
            Arrays.fill(row, 0);

        for (int r = 0; r < cache.length; r++) {
            cache[r][str2.length()] = str2.length() - r;
        }

        for (int c = 0; c < cache[0].length; c++) {
            cache[str1.length()][c] = str1.length() - c;
        }

        for (int i = str1.length() - 1; i >= 0; i--) {
            for (int j = str2.length() - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    cache[i][j] = cache[i + 1][j + 1];
                } else {
                    int insert = cache[i][j + 1] + 1;
                    int delete = cache[i + 1][j] + 1;
                    int replace = cache[i + 1][j + 1] + 1;

                    cache[i][j] = Math.min(Math.min(insert, delete), replace);
                }
            }
        }

        return cache[0][0];
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("Matrix");
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
