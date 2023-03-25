package Landmark;

public class Function {

  public Point[] points;

  public Function(Point[] points) {
    this.points = points;
  }

  public int degree(String name) {
    int degree = 0;
    for (Point point : points) {
      if (point.name.equals(name)) {
        degree = point.degree();
      }
    }
    return degree;
  }
}
