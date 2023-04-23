package SpanningTree;

import java.util.ArrayList;

public class Data {

    public Data() {
        setEdges();
    }

  public ArrayList<Edge> setEdges() {
    ArrayList<Edge> edges = new ArrayList<Edge>();

    edges.add(new Edge("Minneapolis", "Chicago", 355));
    edges.add(new Edge("Minneapolis", "Nashville", 695));
    edges.add(new Edge("Chicago", "St. Louis", 262));
    edges.add(new Edge("Chicago", "Milwaukee", 74));
    edges.add(new Edge("Chicago", "Louisville", 269));
    edges.add(new Edge("St. Louis", "Louisville", 242));
    edges.add(new Edge("Milwaukee", "Louisville", 348));
    edges.add(new Edge("Nashville", "Louisville", 151));
    edges.add(new Edge("Louisville", "Cincinnati", 83));
    edges.add(new Edge("Louisville", "Detroit", 306));
    edges.add(new Edge("Cincinnati", "Detroit", 230));

    return edges;
  }

    public ArrayList<Edge> getEdges() {
        return setEdges();
    }
}
