import java.util.*;

public class Main {
    static int Validation(int num) {
        if (num >= 1 && num <= 1_000_000) {
            return num;
        } else {
            return 0;
        }
    }

    static boolean FindWay(int[][] map, int[] position) {
        int[][] cloneMap = map.clone();
        int[] clonePosition = position.clone(); 

        boolean isFind = false;

        try {
            if(map[clonePosition[0]][clonePosition[1]+1]==1) {
                cloneMap[clonePosition[0]][clonePosition[1]] = 0;
                clonePosition[1] += 1;
                isFind = FindWay(cloneMap, clonePosition);
            }
        } catch (Exception e) {}
        
        try {
            if(map[clonePosition[0]][clonePosition[1]+1]==9) {
                isFind = true;
                return isFind;
            }
        } catch (Exception e) {}
        if(isFind == true) {
            return true;
        }

        try {
            if(map[clonePosition[0]][clonePosition[1]-1]==1) {
                cloneMap[clonePosition[0]][clonePosition[1]] = 0;
                clonePosition[1] -= 1;
                isFind = FindWay(cloneMap, clonePosition);
            }
        } catch (Exception e) {}

        try {
            if(map[clonePosition[0]][clonePosition[1]-1]==9) {
                isFind = true;
                return isFind;
            }
        } catch (Exception e) {}
        if(isFind == true) {
            return true;
        }

        try {
            if(map[clonePosition[0]+1][clonePosition[1]]==1) {
                cloneMap[clonePosition[0]][clonePosition[1]] = 0;
                clonePosition[0] += 1;
                isFind = FindWay(cloneMap, clonePosition);
            }
        } catch (Exception e) {}

        try {
            if(map[clonePosition[0]+1][clonePosition[1]]==9) {
                isFind = true;
                return isFind;
            }
        } catch (Exception e) {}
        if(isFind == true) {
            return true;
        }
        
        try {
            if(map[clonePosition[0]-1][clonePosition[1]]==1) {
                cloneMap[clonePosition[0]][clonePosition[1]] = 0;
                clonePosition[0] -= 1;
                isFind = FindWay(cloneMap, clonePosition);
            }
        } catch (Exception e) {}

        try {
            if(map[clonePosition[0]-1][clonePosition[1]]==9) {
                isFind = true;
                return isFind;
            }
        } catch (Exception e) {}
        if(isFind == true) {
            return true;
        }

        return isFind;
    }
    
    public static void main(String[] args) {
        // Input
        Scanner sc = new Scanner(System.in);

        // Input map size
        int Column = Validation(sc.nextInt());
        int Row = Validation(sc.nextInt());

        // Position of start point and end point
        int currentPosition[] = new int[2];
        int goalPosition[] = new int[2];
        
        // Input map
        int arr[][] = new int[Row][Column];
        for(int i =0;i<Row;i++) {
            for(int j=0;j<Column;j++) {

                arr[i][j] = sc.nextInt();
                
                if(arr[i][j]== -1) {
                    currentPosition[0]=j;
                    currentPosition[1]=i;
                }

                if(arr[i][j]==9) {
                    goalPosition[0]=j;
                    goalPosition[1]=i;
                }
            }
        }

        // Find way
        boolean Result = FindWay(arr, currentPosition);

        // Print out result
        System.out.println(Result ? "Yes" : "No");

        sc.close();
    }
}
