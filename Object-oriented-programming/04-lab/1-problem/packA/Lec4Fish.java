package packA;

public class Lec4Fish implements CanSwimIntf {
    @Override
    public void swim() {
        System.out.println("Flexing my tail back and forth");
    }

    public void fishMethod() {
      System.out.println("Do i?");
    }
}