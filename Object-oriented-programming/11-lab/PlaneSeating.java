public abstract class PlaneSeating {
    protected char[][] seating;

    public abstract void showSeating();

    public abstract boolean reserveSeat(int row, int col);
}
