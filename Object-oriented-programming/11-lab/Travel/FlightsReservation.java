package Travel;

public class FlightsReservation {

  private Flights flight;
  private PlaneSeating seating;

  public FlightsReservation(Flights flight) {
    this.flight = flight;
    this.seating = new Plane22Seating("xx_xx,xx_x^,^x_xx,x^_xx,xx_^x"); // Initialize Plane22Seating without a seating configuration (cs6003)
    this.seating =
      flight.getCode().equals("cs6003")
        ? new Plane22Seating("xx_xx,xx_x^,^x_xx,x^_xx,xx_^x")
        : new Plane22Seating("xx_xx,xx_xx,xx_xx,xx_xx,xx_xx"); // Initialize Plane22Seating with seating configuration for flight cs6003 or without a seating configuration for other flights
  }

  public void showSeating() {
    seating.showSeating();
  }

  public boolean reserveSeat(int row, int col) {
    return seating.reserveSeat(row, col);
  }

  // Getters and setters for flight and seating
  public Flights getFlight() {
    return flight;
  }

  public void setFlight(Flights flight) {
    this.flight = flight;
  }

  public PlaneSeating getSeating() {
    return seating;
  }

  public void setSeating(PlaneSeating seating) {
    this.seating = seating;
  }
}
