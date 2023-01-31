package packA;
import java.util.ArrayList;

public class Programmer extends Employee {
    private ArrayList<String> skills = new ArrayList<>();

    public Programmer(String name, int experience, int salary) {
        super.name = name;
        super.experience = experience;
        super.salary = salary;
    }

    public void setSkills(String[] skills) {
        for(String s : skills) {
            this.skills.add(s);
        }
    }
    
    @Override
    public void sayHi() {
        System.out.printf("Coding in %s%n", this.skills);
    }

    public String coding() {
        return String.format("I'm coding %s", skills);
    }

    public String toString() {
        return String.format("%s [name: %s, experience: %d, salary: %d, skills: %s]", this.getClass().getSimpleName(), super.name, super.experience, super.salary, this.skills);
    }
}
