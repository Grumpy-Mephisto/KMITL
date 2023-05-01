package Travel;

import java.util.HashMap;
import java.util.Map;

public class CSTravel {

  private Map<String, FlightsReservation> catalog = new HashMap<>();
  private Flights cs6003 = new Flights(
    "cs6003",
    City.BKK,
    City.ICN,
    DayOfWeek.Mon,
    Time.pm1
  );
  private Flights cs6004 = new Flights(
    "cs6004",
    City.BKK,
    City.ICN,
    DayOfWeek.Tue,
    Time.pm2
  );
  private Flights cs6005 = new Flights(
    "cs6005",
    City.BKK,
    City.NRT,
    DayOfWeek.Wed,
    Time.pm3
  );
  private Flights cs6006 = new Flights(
    "cs6006",
    City.BKK,
    City.SIN,
    DayOfWeek.Thr,
    Time.pm4
  );
  private Flights cs6007 = new Flights(
    "cs6007",
    City.ICN,
    City.BKK,
    DayOfWeek.Fri,
    Time.pm5
  );

  // Instance initializer block
  {
    catalog.put("cs6003", new FlightsReservation(cs6003));
    catalog.put("cs6004", new FlightsReservation(cs6004));
    catalog.put("cs6005", new FlightsReservation(cs6005));
    catalog.put("cs6006", new FlightsReservation(cs6006));
    catalog.put("cs6007", new FlightsReservation(cs6007));
  }

  public FlightsReservation getFlight(String code) {
    FlightsReservation reservation = catalog.get(code);
    if (reservation != null) {
      System.out.printf(
        "Flight %s from %s to %s on %s at %s\n",
        reservation.getFlight().getCode(),
        reservation.getFlight().getSource(),
        reservation.getFlight().getDestination(),
        reservation.getFlight().getDay(),
        reservation.getFlight().getDepartTime()
      );
      System.out.println("------------");
    }
    return reservation;
  }
}
