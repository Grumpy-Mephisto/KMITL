//Product
public class Person {
   // name, address  
  public String name, streetAddress, postcode, city;

  // employment
  public String companyName, position;
  public int annualIncome;

  public Person(String name) {
    this.name = name;
  }
  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("name: " + name + "\n");
    if (this.streetAddress != null) {
      sb.append("street address: '" + streetAddress + "'\n");
    }
    if (this.postcode != null) {
      sb.append("postcode: " + postcode + "\n");
    }
    if (this.city != null) {
      sb.append("city: " + city + "\n");
    }
    if (this.companyName != null) {
      sb.append("companay name: " + companyName + "\n");
    }
    if (this.position != null) {
      sb.append("position: " + position + "\n");
    }
    if (this.annualIncome != 0) {
      sb.append("annual income: " + annualIncome + "\n");
    }
    return sb.toString();
  }       
}
