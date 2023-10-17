import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Prim Algorithm
 * 
 * @author 65050437
 */
public class Prim {
    public int[][] graph;
    private PriorityQueue<PrimEdge> queue;

    public Prim(int[][] graph) {
        this.graph = graph;
        this.queue = new PriorityQueue<PrimEdge>();
    }

    public static void PrimEdgeToPriorityQueue(PrimEdge input, PriorityQueue<PrimEdge> queue) {
        PrimEdge flag = null;
        for (PrimEdge primEdge : queue) {
            if (primEdge.getV() == input.getV()) {
                flag = primEdge;
            }
        }
        if (flag != null) {
            if (input.getWeight() < flag.getWeight()) {
                flag.setU(input.getU());
                flag.setWeight(input.getWeight());
            }
        } else
            queue.add(input);
    }

    public int[][] getMST() {
        return this.getMST(0);
    }

    public int[][] getMST(int root) {
        int tree[][] = new int[graph.length][graph[0].length];
        for (int i = 0; i < graph.length; i++) {
            if (graph[root][i] > 0) {
                PrimEdgeToPriorityQueue(new PrimEdge(root, i, graph[root][i]), queue);
                graph[root][i] *= -1;
                graph[i][root] *= -1;
            }
        }
        while (!queue.isEmpty()) {
            PrimEdge primEdge = queue.poll();
            tree[primEdge.getU()][primEdge.getV()] = primEdge.getWeight();
            tree = mergeTree(tree, getMST(primEdge.getV()));
        }
        graph = absoluteElement(graph);
        return tree;
    }

    public static int[][] mergeTree(int[][] array1, int[][] array2) {
        int rows = array1.length;
        int cols = array1[0].length;
        if (rows == array2.length && cols == array2[0].length) {
            int[][] result = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = array1[i][j] + array2[i][j];
                }
            }
            return result;
        } else {
            return null;
        }
    }

    private static int[][] absoluteElement(int[][] tree) {
        int absArr[][] = new int[tree.length][tree[0].length];
        for (int i = 0; i < tree.length; i++) {
            for (int j = 0; j < tree[0].length; j++) {
                absArr[i][j] = Math.abs(tree[i][j]);
            }
        }
        return absArr;
    }

    public static void showTreeAdjacency(int[][] tree) {
        for (int[] row : tree) {
            System.out.println(Arrays.toString(row));
        }
    }
}
