import java.util.*;

class ProFun09_Q3_50437 {
    public static void main(String[] args) {
        int[][] map = new int[8][13];

        // Initialize map
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        // Mark the bomb locations
        System.out.println("\nMinesweeper:");
        MarkMap(map);
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

    static int[][] MarkMap(int[][] bMap) {
        Random random = new Random();
        int bomb = random.nextInt(52);

        for(int i = 0; i < bomb; i++) {
            int cols = random.nextInt(8);
            int rows = random.nextInt(13);
            bMap[cols][rows] = 9;
        }

        for(int col = 0; col < bMap.length; col++) {
            for(int row = 0; row < bMap[col].length; row++) {
                if(bMap[col][row] != 9) {
                    int count = 0;

                    for(int i = -1; i <= 1; i++) {
                        for(int j = -1; j <= 1; j++) {
                            if(col + i >= 0 && col + i < bMap.length && row + j >= 0 && row + j < bMap[col].length) {
                                if(bMap[col + i][row + j] == 9) {
                                    count++;
                                }
                            }
                        }
                    }
                    bMap[col][row] = count;
                }
            }
        }

        return bMap;
    }
}