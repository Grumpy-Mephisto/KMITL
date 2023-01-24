package packA;

public class EmpTmp {
  private String name;
  protected int salary;
  private int experience;

  public EmpTmp(String n, int exp, int sal) {
    this.name = n;
    this.experience = exp;
    this.salary = sal;
  }

  public EmpTmp(String n) {
    this.name = n;
  }
  
  public EmpTmp() {}

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
    return String.format("EmpTmp [name=%s, salary=%d, experience=%d]", name, salary, experience);
  }
  
  public void sayHi() {
    System.out.printf("Hi from %s [%s]%n", name, this.getClass().getSimpleName());
  }
}
