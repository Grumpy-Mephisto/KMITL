import PolishNotation.*;
import Trees.*;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // System.out.print("Enter your equation: ");
    // String equation = scanner.nextLine();
    String equation = "5 + 2 / 4 * 6";
    scanner.close();

    Notation polishNotation = new Notation();
    polishNotation.setEquation(equation);
    System.out.println("Infix: " + polishNotation.getInfix());
    System.out.println("Prefix: " + polishNotation.getPrefix());
    System.out.println("Postfix: " + polishNotation.getPostfix());
  }
}
