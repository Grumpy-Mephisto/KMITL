import java.util.Scanner;

public class PairOfInputProcessor {
    public static PairOfInput read() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        String firstNumber = inp.nextLine();
        System.out.print("Enter the second number: ");
        String secondNumber = inp.nextLine();
        inp.close();

        PairOfInput pair = new PairOfInput(firstNumber, secondNumber);
        return pair;
    }

    public static boolean isValid(PairOfInput pair) {
        String first = pair.getFirst();
        String second = pair.getSecond();

        try {
            Integer.parseInt(first);
            Integer.parseInt(second);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
