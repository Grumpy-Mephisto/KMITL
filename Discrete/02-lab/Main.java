import Matrix.AdjacencyMatrix;
import java.util.Scanner;

public class Main {

  public static final int ROW = 5;
  public static final int COL = 5;

  public static void main(String[] args) {
    AdjacencyMatrix matrix = new AdjacencyMatrix(ROW, COL);

    int[][] edges = {
      { 0, 1 },
      { 0, 2 },
      { 0, 3 },
      { 1, 1 },
      { 1, 2 },
      { 1, 4 },
      { 2, 3 },
      { 2, 4 },
      { 3, 4 },
    };

    matrix.createAdjacencyMatrix(edges);
    matrix.printMatrix(matrix.adjacencyMatrix);

    System.out.println();

    Scanner input = new Scanner(System.in);
    System.out.print(
      "Enter the number of times you want to multiply the matrix: "
    );
    int times = input.nextInt();
    input.close();

    int[][] result = matrix.multiplyMatrix(ROW, COL, times);
    matrix.printMatrix(result);
  }
}
