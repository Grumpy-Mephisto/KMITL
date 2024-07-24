import java.util.Scanner;

public class FToC {
  public static void main(String[] args) {
    double fahrenheit, celsius;
    Scanner inp = new Scanner(System.in);

    System.out.print("enter degree in fahrenheit ");

    fahrenheit = inp.nextDouble();
    celsius = (5.0 / 9.0) * (fahrenheit - 32);
    System.out.println(fahrenheit + " fahrenheit = " + celsius + " celsius");

    inp.close();
  }
}
