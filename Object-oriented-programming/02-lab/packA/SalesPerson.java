package packA;

public class SalesPerson extends Programmer {
    private int target;

    public SalesPerson(String n, int exp, int sal, int assignedTarget) {
        super(n, exp, sal);
        this.target = assignedTarget;
    }

    public SalesPerson(String n, int exp) {
        super(n);
        super.setExperience(exp);
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getTarget() {
        return target;
    }

    public void setSalary() {} 

    @Override
    public void setSalary(int increasedAmount) {
        super.salary += increasedAmount;
    }

    public String makeQuotation() {
        int number = (int)(Math.random() * 1000) + 1;
        return String.format("Dear value customer, %d is my best offer", number);
    }

    @Override
    public String toString() {
        return String.format("SalesPerson [target=%d %s]", target, super.toString());
    }
}