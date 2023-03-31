package Matrix;

import java.util.Arrays;

public class AdjacencyMatrix {

  public int row, col;
  public int[][] adjacencyMatrix;

  public AdjacencyMatrix(int row, int col) {
    this.row = row;
    this.col = col;
  }

  public int[][] createAdjacencyMatrix(int[][] edges) {
    adjacencyMatrix = new int[row][col];

    for (int i = 0; i < edges.length; i++) {
      int startNode = edges[i][0];
      int endNode = edges[i][1];

      adjacencyMatrix[startNode][endNode] += 1;
      adjacencyMatrix[endNode][startNode] += 1;
    }

    return adjacencyMatrix;
  }

  public void printMatrix(int[][] matrix) {
    Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);
  }

  public int[][] multiplyMatrix(int row, int col, int times) {
    int[][] result = new int[row][col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        for (int k = 0; k < row; k++) {
          result[i][j] += adjacencyMatrix[i][k] * adjacencyMatrix[k][j];
        }
      }
    }

    return result;
  }
}
