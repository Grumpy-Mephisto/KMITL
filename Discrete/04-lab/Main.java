import SpanningTree.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Data data = new Data();
    Prompt prompt = new Prompt();
    PrimAlgorithm prim = new PrimAlgorithm(data.getEdges());

    ArrayList<Edge> cities = data.getEdges();
    prompt.User(cities);

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter starting city name (or number): ");
    String startCity = scanner.nextLine();
    scanner.close();

    if ((startCity instanceof String) && (startCity.matches("[0-9]+"))) {
      startCity = prompt.CityName(Integer.parseInt(startCity));
    }
    prim.run(startCity);
  }
}
