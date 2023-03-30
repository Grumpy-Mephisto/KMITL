import java.util.ArrayList;

public class Graph {

  public ArrayList<Node> nodes = new ArrayList<Node>();
  public ArrayList<Edge> edges = new ArrayList<Edge>();

  public static void main(String[] args) {
    Graph graph = new Graph();
    graph.nodes.add(new Node("A"));
    graph.nodes.add(new Node("B"));
    graph.nodes.add(new Node("C"));
    graph.nodes.add(new Node("X"));
    graph.nodes.add(new Node("Y"));
    graph.nodes.add(new Node("Z"));

    graph.edges.add(new Edge(graph.nodes.get(0), graph.nodes.get(0)));
    graph.edges.add(new Edge(graph.nodes.get(0), graph.nodes.get(1)));
    graph.edges.add(new Edge(graph.nodes.get(0), graph.nodes.get(2)));
    graph.edges.add(new Edge(graph.nodes.get(1), graph.nodes.get(3)));
    graph.edges.add(new Edge(graph.nodes.get(1), graph.nodes.get(4)));
    graph.edges.add(new Edge(graph.nodes.get(2), graph.nodes.get(5)));

    for (Edge edge : graph.edges) {
      if (edge.from == edge.to) {
        System.out.println(edge + " (self-loop)");
      } else {
        System.out.println(edge);
      }
    }
  }

  public static class Node {

    public String name;
    public ArrayList<Edge> edges = new ArrayList<Edge>();

    public Node(String name) {
      this.name = name;
    }

    public int outDegree() {
      int count = 0;
      for (Edge edge : edges) {
        if (edge.from == this) {
          count++;
        }
      }
      return count;
    }

    public int inDegree() {
      int count = 0;
      for (Edge edge : edges) {
        if (edge.to == this) {
          count++;
        }
      }
      return count;
    }

    public String toString() {
      return name;
    }
  }

  public static class Edge {

    public Node from;
    public Node to;

    public Edge(Node from, Node to) {
      this.from = from;
      this.to = to;
      from.edges.add(this);
      to.edges.add(this);
    }

    public String toString() {
      return String.format(
        "Edge: %s -> %s [out-degree: %d | in-degree: %d]",
        from,
        to,
        from.outDegree(),
        to.inDegree()
      );
    }
  }
}
