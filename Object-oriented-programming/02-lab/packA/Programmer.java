package packA;

public class Programmer {
  private String name;
  protected int salary;
  private int experience;

  public Programmer(String n, int exp, int sal) {
    this.name = n;
    this.experience = exp;
    this.salary = sal;
  }

  public Programmer(String n) {
    this.name = n;
  }
  
  public Programmer() {}

  public void setName(String name) {
      this.name = name;
  }

  public String getName() {
      return name;
  }

  public void setSalary(int newSalary) {
    this.salary = newSalary;
  }

  public int getSalary() {
      return salary;
  }

  public void setExperience(int experience) {
      this.experience = experience;
  }

  public int getExperience() {
      return experience;
  }

  @Override
  public String toString() {
    return String.format("Programmer [name=%s, salary=%d, experience=%d]", name, salary, experience);
  }
  
  public void sayHi() {
    System.out.println("hi from " + name);
  }
}
