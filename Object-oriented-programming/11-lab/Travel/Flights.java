package Travel;

public class Flights {

  private String code;
  private City source;
  private City destination;
  private DayOfWeek day;
  private Time departTime;

  public Flights(
    String code,
    City source,
    City destination,
    DayOfWeek day,
    Time departTime
  ) {
    this.code = code;
    this.source = source;
    this.destination = destination;
    this.day = day;
    this.departTime = departTime;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public City getSource() {
    return source;
  }

  public void setSource(City source) {
    this.source = source;
  }

  public City getDestination() {
    return destination;
  }

  public void setDestination(City destination) {
    this.destination = destination;
  }

  public DayOfWeek getDay() {
    return day;
  }

  public void setDay(DayOfWeek day) {
    this.day = day;
  }

  public Time getDepartTime() {
    return departTime;
  }

  public void setDepartTime(Time departTime) {
    this.departTime = departTime;
  }
}
