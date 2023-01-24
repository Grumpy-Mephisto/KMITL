package packA;

public class Programmer extends EmpTmp {
    public Programmer(String n, int exp, int sal) {
        super(n, exp, sal);
    }

    @Override
    public void sayHi() {
        super.sayHi();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String coding() {
        return String.format("I am coding in %s", this.getClass().getSimpleName());
    }
}
