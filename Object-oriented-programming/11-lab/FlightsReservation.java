public class FlightsReservation {
    private Flights flight;
    private PlaneSeating seating;

    public FlightsReservation(Flights flight) {
        this.flight = flight;
    }

    public void showSeating() {
        seating.showSeating();
    }

    public boolean reserveSeat(int row, int col) {
        return seating.reserveSeat(row, col);
    }
}
