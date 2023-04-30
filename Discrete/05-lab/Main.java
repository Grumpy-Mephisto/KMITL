import FiniteAutomata.FiniteStateAutomata;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    FiniteStateAutomata fsa = new FiniteStateAutomata();
    Scanner scanner = new Scanner(System.in);
    // The accepted strings are the ones that end with either "01" or "10" and after processing the entire string
    System.out.print("Enter a string of 0 and 1: "); // **01 or **10, the final state is 4
    String input = scanner.nextLine();
    scanner.close();
    fsa.processInput(input);
  }
}
