import Landmark.*;
import java.util.ArrayList;

public class Graph {

  public static void main(String[] args) {
    // Create point
    Point Landmark1 = new Point(
      "Bangkok",
      new ArrayList<String>() {
        {
          add("Chiang Mai");
          add("Phuket");
        }
      },
      new ArrayList<String>() {
        {
          add("Koh Samui");
          add("Koh Tao");
          add("Koh Phangan");
        }
      }
    );

    Point Landmark2 = new Point(
      "Chiang Mai",
      new ArrayList<String>() {
        {
          add("Koh Samui");
        }
      },
      new ArrayList<String>() {
        {
          add("Bangkok");
        }
      }
    );

    Point Landmark3 = new Point(
      "Phuket",
      new ArrayList<String>() {
        {
          add("Koh Tao");
          add("Koh Phangan");
        }
      },
      new ArrayList<String>() {
        {
          add("Bangkok");
        }
      }
    );

    // Create function
    Function function = new Function(
      new Point[] { Landmark1, Landmark2, Landmark3 }
    );

    // Print result
    for (Point point : function.points) {
      System.out.println(point);
    }
  }
}
