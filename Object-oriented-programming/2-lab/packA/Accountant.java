package packA;

public class Accountant extends Programmer {
    private static String companyName = "berk barn jamked";
    private int experience;
    private String specialty;

    public Accountant(String name, int superExp, int experience, int sal, String talent) {
        super(name, experience, sal);
        this.experience = superExp;
        this.specialty = talent;
    }

    public void setSpecialty(String newSpecialty) {
        this.specialty = newSpecialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setAccountExperience () {
        this.experience = super.getExperience();
    } 

    public int getAccountExperience() {
        return experience;
    }

    public String tellProfit() {
        int number = (int)(Math.random() * 1000) + 1;
        return String.format("%s's profit is %d. My salary is %d", companyName, number, super.getSalary());
    }

    @Override
    public void sayHi() {
        int number = (int)(Math.random() * 1000) + 1;
        System.out.printf("%s's profit is %d. My salary is %d%n", companyName, number, super.getSalary());
    }

    @Override
    public String toString() {
        return String.format("%s %d %d can %s", super.getName(), experience, super.getExperience(), specialty);
    }

    public static String tellMyRole() {
        return String.format("I am an accountant at %s", companyName);
    }
}