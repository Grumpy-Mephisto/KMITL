package SpanningTree;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimAlgorithm {

  private PriorityQueue<String[]> pq;
  private ArrayList<String> visited;
  private String startCity;
  private ArrayList<String[]> graph;

  public PrimAlgorithm(ArrayList<String[]> graph, String startCity) {
    pq =
      new PriorityQueue<String[]>((a, b) ->
        Integer.parseInt(a[2]) - Integer.parseInt(b[2])
      );
    visited = new ArrayList<String>();
    visited.add(startCity);
    this.startCity = startCity;
    this.graph = graph;
  }

  private String[] prim() {
    for (String[] edge : graph) {
      if (edge[0].equals(startCity) || edge[1].equals(startCity)) {
        pq.add(edge);
      }
    }

    while (!pq.isEmpty() && visited.size() < graph.size() + 1) {
      String[] edge = pq.poll();
      String nextCity = edge[0].equals(visited.get(visited.size() - 1))
        ? edge[1]
        : edge[0];
      if (!visited.contains(nextCity)) {
        if (visited.size() == 1) {
          System.out.println();
        }
        visited.add(nextCity);
        System.out.printf(
          "Added edge: %s\t----->\t%s \t(%s)%n",
          edge[0],
          edge[1],
          edge[2]
        );
        for (String[] newEdge : graph) {
          if (newEdge[0].equals(nextCity) || newEdge[1].equals(nextCity)) {
            pq.add(newEdge);
          }
        }
      }
    }

    return visited.toArray(new String[visited.size()]);
  }

  public void print() {
    String[] results = prim();
    for (int i = 0; i < results.length; i++) {
      if (i == 0) {
        System.out.println();
      }
      System.out.print(results[i]);
      if (i < results.length - 1) {
        System.out.print(" -> ");
      } else {
        int totalDistance = 0;
        for (String[] edge : graph) {
          if (visited.contains(edge[0]) && visited.contains(edge[1])) {
            totalDistance += Integer.parseInt(edge[2]);
          }
        }
        System.out.printf(" (Total distance: %s)%n", totalDistance);
      }
    }
  }
}
