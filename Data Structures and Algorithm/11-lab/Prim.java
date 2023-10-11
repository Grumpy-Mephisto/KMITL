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

    public int[][] getMST() {
        return this.getMST(0);
    }

    public int[][] getMST(int start) {
        int[][] tree = new int[this.graph.length][this.graph.length];
        boolean[] visited = new boolean[this.graph.length];

        for (int i = 0; i < this.graph.length; i++) {
            Arrays.fill(tree[i], 0);
        }

        visited[start] = true;
        for (int i = 0; i < this.graph.length - 1; i++) {
            for (int j = 0; j < this.graph.length; j++) {
                if (visited[j]) {
                    for (int k = 0; k < this.graph.length; k++) {
                        if (!visited[k] && this.graph[j][k] != 0) {
                            this.queue.add(new PrimEdge(j, k, this.graph[j][k]));
                        }
                    }
                }
            }

            PrimEdge edge = this.queue.poll();
            tree[edge.u][edge.v] = edge.weight;
            tree[edge.v][edge.u] = edge.weight;
            visited[edge.v] = true;
        }

        return tree;
    }

    public static void showTreeAdjacency(int[][] tree) {
        for (int[] row : tree) {
            System.out.println(Arrays.toString(row));
        }
    }
}
