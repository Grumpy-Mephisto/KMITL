package Landmark;

import java.util.ArrayList;

public class Point {

  public String name;
  public ArrayList<String> out;
  public ArrayList<String> in;

  public Point(String name, ArrayList<String> in, ArrayList<String> out) {
    this.name = name;
    this.out = out;
    this.in = in;
  }

  public int degree() {
    return out.size() + in.size();
  }

  @Override
  public String toString() {
    return String.format(
      "From %s\nOut: %s\nIn: %s\nDegree: %d \n====================",
      name,
      out.toString(),
      in.toString(),
      degree()
    );
  }
}
