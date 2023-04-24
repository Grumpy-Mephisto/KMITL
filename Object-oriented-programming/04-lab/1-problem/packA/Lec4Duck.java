package packA;

public class Lec4Duck implements CanSwimIntf {
    @Override
    public void swim() {
        System.out.println("Waddling");
    }

    public void duckMethod() {
      System.out.println("Quack");
    }
}