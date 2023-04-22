import SpanningTree.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Data data = new Data();
    ArrayList<String[]> graph = data.getData();
    String startCity = getInput(graph);
    PrimAlgorithm primAlgorithm = new PrimAlgorithm(graph, startCity);
    primAlgorithm.print();
  }

  private static String getInput(ArrayList<String[]> graph) {
    System.out.println("What is the starting city?");
    ArrayList<String> cities = new ArrayList<String>();
    for (String[] edge : graph) {
      if (!cities.contains(edge[0])) {
        cities.add(edge[0]);
      }
      if (!cities.contains(edge[1])) {
        cities.add(edge[1]);
      }
    }
    for (int i = 0; i < cities.size(); i++) {
      System.out.println((i + 1) + ". " + cities.get(i));
    }
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter starting city: ");
    String startCity = scanner.nextLine();
    scanner.close();
    if (!cities.contains(startCity)) {
      System.out.printf("Invalid city. Defaulting to %s.%n", cities.get(0));
      startCity = cities.get(0);
    }
    return startCity;
  }
}
