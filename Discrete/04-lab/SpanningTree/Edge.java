package SpanningTree;

public class Edge {

  private int distance;
  private String cityTo;
  private String cityFrom;

  public Edge(String cityFrom, String cityTo, int distance) {
    this.cityFrom = cityFrom;
    this.cityTo = cityTo;
    this.distance = distance;
  }

  public String getCityFrom() {
    return cityFrom;
  }

  public String getCityTo() {
    return cityTo;
  }

  public int getDistance() {
    return distance;
  }

  public String toString() {
    return String.format(
      "%s \t----->\t  %s\t(distance: %d)",
      cityFrom,
      cityTo,
      distance
    );
  }
}
