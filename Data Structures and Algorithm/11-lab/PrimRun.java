import java.util.Arrays;

public class PrimRun {
    public static void main(String[] args) {
        int[][] data = {{0, 2, 0, 6, 0}, {2, 0, 3, 8, 5}, {6, 8, 0, 0, 9}, {0, 5, 7, 9, 0}};
        Prim mst = new Prim(data);

        System.out.println("⋯⋯⋯ Input ⋯⋯⋯");
        for (int[] row : mst.graph) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("⋯⋯⋯");
        Prim.showTreeAdjacency(mst.getMST());

        /*
         * Expected Output: [0, 2, 0, 6, 0] [0, 0, 3, 0, 5] [0, 0, 0, 0, 0] [0, 0, 0, 0, 0] [0, 0,
         * 0, 0, 0]
         */
        System.out.println("⋯⋯⋯");
        Prim.showTreeAdjacency(mst.getMST(2));
        /*
         * Expected Output: [0, 0, 0, 6, 0], [2, 0, 0, 0, 5] [0, 3, 0, 0, 0], [0, 0, 0, 0, 0] [0, 0,
         * 0, 0, 0]
         */
    }
}
