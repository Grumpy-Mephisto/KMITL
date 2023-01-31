package packA;

public class Accountant extends Employee {
    private static String companyName = "berk barn jamked";
    private int experience;
    private String specialty;

    public Accountant(String name, int superExp, int experience, int salary, String talent) {
        super.name = name;
        super.experience = superExp;
        this.experience = experience;
        super.salary = salary;
        this.specialty = talent;
    }

    public void setSpecialty(String newSpecialty) {
        this.specialty = newSpecialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setAccountExperience (int newExperience) {
        this.experience = newExperience;
    } 

    public int getAccountExperience() {
        return experience;
    }

    public String tellProfit() {
        int number = (int)(Math.random() * 1000) + 1;
        return String.format("%s's profit is %d. My salary is %d", companyName, number, super.salary);
    }

    @Override
    public void sayHi() {
        int number = (int)(Math.random() * 1000) + 1;
        System.out.printf("%s's profit is %d. My salary is %d [%s]%n", companyName, number, super.salary, this.getClass().getSimpleName());
    }

    public static String tellMyRole() {
        return String.format("I am an accountant at %s", companyName);
    }

    public String toString() {
        return String.format("%s [name: %s, experience: %d, salary: %d, specialty: %s]", this.getClass().getSimpleName(), super.name, super.experience, super.salary, this.specialty);
    }
}