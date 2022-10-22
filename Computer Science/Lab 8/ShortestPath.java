import java.util.*;

public class ShortestPath {
    public static void main(String[] args) {
        int tmp = 0;
        
        int[][] adja ={{ 0, 2, 6, 711, 711, 711, 711 },
                    { 2, 0, 711, 5, 711, 711, 711 },
                    { 6, 711, 0, 8, 711, 711, 711 },
                    { 711, 5, 8, 0, 10, 15, 711 },
                    { 711, 711, 711, 10, 0, 6, 2 },
                    { 711, 711, 711, 15, 6, 0, 6 },
                    { 711, 711, 711, 711, 2, 6, 0 } };

        int[] dist ={ 0, 711, 711, 711, 711, 711, 711 };

        for (int city = 0; city < adja.length; city++) {
            for (int dest = 1; dest < adja.length; dest++) {
                if (dist[dest] < 711) {
                    System.out.println("dest " + dest + " dist " + dist[dest]); 
                    /*  
                    Q1: Show the result
                        ------------------------
                        dest 1 dist 2
                        dest 2 dist 6
                        ------------------------
                        dest 1 dist 2
                        dest 2 dist 6
                        dest 3 dist 7
                        ------------------------
                        dest 1 dist 2
                        dest 2 dist 6
                        dest 3 dist 7
                        ------------------------
                        dest 1 dist 2
                        dest 2 dist 6
                        dest 3 dist 7
                        dest 4 dist 17
                        dest 5 dist 22
                        ------------------------
                        dest 1 dist 2
                        dest 2 dist 6
                        dest 3 dist 7
                        dest 4 dist 17
                        dest 5 dist 22
                        dest 6 dist 19
                        ------------------------
                        dest 1 dist 2
                        dest 2 dist 6
                        dest 3 dist 7
                        dest 4 dist 17
                        dest 5 dist 22
                        dest 6 dist 19
                        ------------------------
                    */
                }
                if(dist[city] + adja[city][dest] < dist[dest]) {
                    /* 
                    Q2: Fill the code 
                        [city] + adja[city][dest] < dist[dest]
                    */
                    tmp++;
                    dist[dest] = dist[city] + adja[city][dest];
                }
            }
            System.out.println("------------------------");
        }
        System.out.println(tmp); 
        /*
        Q3: Show the result
            6
        */ 
        System.out.println(Arrays.toString(dist));
        /*
        Q4: Show the result
            [0, 2, 6, 7, 17, 19, 19]
        */
    }
}