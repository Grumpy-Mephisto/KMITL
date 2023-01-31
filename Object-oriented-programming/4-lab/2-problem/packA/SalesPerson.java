package packA;

public class SalesPerson extends Employee implements SalesRoles {
    private int target;

    public SalesPerson(String name, int experience, int salary, int assignedTarget) {
        super.name = name;
        super.experience = experience;
        super.salary = salary;
        this.target = assignedTarget;
    }

    public SalesPerson(String name, int experience) {
        super.name = name;
        super.experience = experience;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getTarget() {
        return target;
    }

    public void setSalary() {} 

    public void setSalary(int increasedAmount) {
        super.salary += increasedAmount;
    }

    @Override
    public void sayHi() {
        System.out.printf("Hi, I'm %s and I'm %d years old and I'm earning %d $ [%s]%n", super.name, super.experience, super.salary, this.getClass().getSimpleName());
    }

    @Override
    public String makeQuotation() {
        int number = (int)(Math.random() * 1000) + 1;
        return String.format("Dear value customer, %d is my best offer", number);
    }

    public String toString() {
        return String.format("%s [name: %s, experience: %d, salary: %d, target: %d]", this.getClass().getSimpleName(), super.name, super.experience, super.salary, this.target);
    }
}