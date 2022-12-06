import java.io.*;

class LabDP_50437 {
    static int KnapSack(int[] itemW, int[] itemV, int C) {
        int[][] table = new int[itemW.length + 1][C + 1];
        int item = 0;
        int weightSoFar = 0;
        int curWeight = 0;
        int curValue = 0;

        // Initialize row0 and col0 to zero (omitted here)
        for(item = 1; item <= itemW.length; item++) {
            for(weightSoFar = 0; weightSoFar <= C; weightSoFar++) {
                curWeight = itemW[item - 1];
                curValue = itemV[item - 1];
                table[item][weightSoFar] = table[item - 1][weightSoFar];

                if(weightSoFar - curWeight >= 0) {
                    if(curValue + table[item - 1][weightSoFar - curWeight] > table[item - 1][weightSoFar]) {
                        table[item][weightSoFar] = curValue + table[item - 1][weightSoFar - curWeight];
                    }
                } else {
                    System.out.println("Negative index");
                }
            }
        }

        for(int i = 0; i < table.length; i++) {
            for(int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

        printAnswer(table);

        return table[itemW.length][C];
    }

    static void printAnswer(int[][] table) {
        try {
            PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
            for(int i = 0; i < table.length; i++) {
                for(int j = 0; j < table[i].length; j++) {
                    writer.print(table[i][j] + " ");
                }
                writer.println();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }

    public static void main(String[] args) {
        int C = 16;
        int[] itemW = {2, 10, 5, 5};
        int[] itemV = {20, 50, 30, 10};
        System.out.println("Result = " + KnapSack(itemW, itemV, C));
    }
}