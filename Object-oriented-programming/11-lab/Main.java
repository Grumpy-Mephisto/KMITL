import Travel.*;

public class Main {

  public static void main(String[] args) {
    CSTravel csTravel = new CSTravel();
    FlightsReservation flight6003 = csTravel.getFlight("cs6003");
    flight6003.showSeating();
    System.out.println("------------");
    boolean isSuccess;
    isSuccess = flight6003.reserveSeat(2, 3);
    flight6003.showSeating();
    System.out.printf(
      "Reserving 2, 3 is %s! %s :(\n",
      isSuccess ? "Success" : "Fail",
      isSuccess ? "Changed" : "No change"
    );
    System.out.println("------------");
    isSuccess = flight6003.reserveSeat(3, 1);
    flight6003.showSeating();
    System.out.printf(
      "Reserving 3, 1 is %s! %s :)\n",
      isSuccess ? "Success" : "Fail",
      isSuccess ? "Changed" : "No change"
    );
  }
}
