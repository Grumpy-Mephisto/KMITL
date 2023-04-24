package packA;

public class ProgrammerManager extends Programmer implements ManagerRoles {
    public ProgrammerManager(String name, int experience, int salary, String[] skills) {
        super(name, experience, salary);
        super.setSkills(skills);
    }

    @Override
    public void sayHi() {
        super.sayHi();
    }

    @Override
    public int evaluate(Programmer p) {
        return (int) (p.salary * 1.15);
    }

    @Override
    public String toString() {
        return String.format("%s [name: %s, experience: %d, salary: %d]", this.getClass().getSimpleName(), super.name, super.experience, super.salary);
    }
}