public class Plane22Seating extends PlaneSeating {
    private Flights flight;

    public Plane22Seating(Flights flight, int rows, int cols) {
        this.flight = flight;
        seating = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seating[i][j] = '-';
            }
        }
    }

    @Override
    public void showSeating() {
        for (int i = 0; i < seating.length; i++) {
            for (int j = 0; j < seating[i].length; j++) {
                System.out.print(seating[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean reserveSeat(int row, int col) {
        if (row >= 0 && row < seating.length && col >= 0 && col < seating[row].length && seating[row][col] == '-') {
            seating[row][col] = 'X';
            return true;
        }
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < seating.length; i++) {
            for (int j = 0; j < seating[i].length; j++) {
                if (seating[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
