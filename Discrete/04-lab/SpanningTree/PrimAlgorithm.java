package SpanningTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PrimAlgorithm {

  private HashSet<String> visited;
  private HashMap<String, ArrayList<Edge>> adjacencyList;

  public PrimAlgorithm(ArrayList<Edge> edges) {
    visited = new HashSet<String>();
    adjacencyList = new HashMap<String, ArrayList<Edge>>();

    // Create adjacency list
    for (Edge edge : edges) {
      if (!adjacencyList.containsKey(edge.getCityFrom())) {
        adjacencyList.put(edge.getCityFrom(), new ArrayList<Edge>());
      }
      if (!adjacencyList.containsKey(edge.getCityTo())) {
        adjacencyList.put(edge.getCityTo(), new ArrayList<Edge>());
      }
      adjacencyList.get(edge.getCityFrom()).add(edge);
      adjacencyList.get(edge.getCityTo()).add(edge);
    }
  }

  public void run(String startCity) {
    visited.add(startCity);

    while (visited.size() < adjacencyList.size()) {
      Edge minEdge = null;

      for (String city : visited) {
        ArrayList<Edge> cityEdges = adjacencyList.get(city);

        for (Edge edge : cityEdges) {
          if (
            !visited.contains(edge.getCityFrom()) ||
            !visited.contains(edge.getCityTo())
          ) {
            if (minEdge == null || edge.getDistance() < minEdge.getDistance()) {
              minEdge = edge;
            }
          }
        }
      }

      if (minEdge != null) {
        if (visited.size() == 1) {
          System.out.println(
            "========================================================"
          );
        }
        System.out.println(minEdge.toString());
        visited.add(minEdge.getCityFrom());
        visited.add(minEdge.getCityTo());
      }
    }
  }
}
