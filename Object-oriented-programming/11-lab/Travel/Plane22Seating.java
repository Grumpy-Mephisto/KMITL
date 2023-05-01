package Travel;

public class Plane22Seating extends PlaneSeating {

  public Plane22Seating(String args) {
    super();
    String[] tokens = args.split(",");
    int numRow = tokens.length;
    int numCol = tokens[0].length();
    seating = new char[numRow][numCol];
    for (int i = 0; i < numRow; i++) {
      seating[i] = tokens[i].toCharArray();
    }
  }

  // x = reserved
  // ^ = available
  // _ = aisle

  @Override
  public void showSeating() {
    for (int i = 0; i < seating.length; i++) {
      System.out.printf("Row %d --> ", i + 1);
      for (int j = 0; j < seating[0].length; j++) {
        System.out.print(seating[i][j] + "");
      }
      System.out.println();
    }
  }

  @Override
  public boolean reserveSeat(int row, int col) {
    if (
      row >= 0 && row < 22 && col >= 0 && col < 6 && seating[row][col] == '^'
    ) {
      seating[row][col] = 'x'; // Reserve the seat
      return true;
    }
    return false;
  }

  public boolean isFull() {
    for (int i = 0; i < 22; i++) {
      for (int j = 0; j < 6; j++) {
        if (seating[i][j] == '^') { // Check if there is any available seat
          return false;
        }
      }
    }
    return true;
  }
}
