import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

interface BinaryOperation {
    int calculate(int a, int b);

    String getOperationName();
}


class Addition implements BinaryOperation {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }

    @Override
    public String getOperationName() {
        return "Addition";
    }
}


class Subtraction implements BinaryOperation {
    @Override
    public int calculate(int a, int b) {
        return a - b;
    }

    @Override
    public String getOperationName() {
        return "Subtraction";
    }
}


public class Ex2WithSRPBinary {
    public static final int MAX = 5;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Application!");

        List<BinaryOperation> operations = new ArrayList<>();
        operations.add(new Addition());
        operations.add(new Subtraction());

        System.out.println("Enter 5 valid integers in the range [0, 10]");

        List<Integer> nums = getInputNumbers();
        nums = sortNumbers(nums);

        System.out.println("\nInput numbers:");
        displayNumbers(nums);

        System.out.println("\n\nResults of operations:");
        performOperations(nums, operations);

        input.close();
    }

    private static List<Integer> getInputNumbers() {
        List<Integer> nums = new ArrayList<>();

        while (nums.size() < MAX) {
            String input = getUserInput();
            if (isValidInteger(input)) {
                int num = Integer.parseInt(input);
                if (isValidRange(num)) {
                    nums.add(num);
                }
            }
        }

        return nums;
    }

    private static String getUserInput() {
        return input.nextLine();
    }

    private static boolean isValidInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid! Try again!");
            return false;
        }
    }

    private static boolean isValidRange(int num) {
        if (num < 0 || num > 10) {
            System.out.println("Invalid range! Try again!");
            return false;
        }
        return true;
    }

    private static List<Integer> sortNumbers(List<Integer> nums) {
        Collections.sort(nums);
        return nums;
    }

    private static void displayNumbers(List<Integer> nums) {
        for (int num : nums)
            System.out.print(num + " ");
    }

    private static void performOperations(List<Integer> nums, List<BinaryOperation> operations) {
        for (BinaryOperation op : operations) {
            System.out.println("\n" + op.getOperationName() + " results:");
            for (int i = 0; i < nums.size(); i++) {
                for (int j = i + 1; j < nums.size(); j++) {
                    int result = op.calculate(nums.get(i), nums.get(j));
                    System.out.printf("%d %s %d = %d\n", nums.get(i),
                            op instanceof Addition ? "+" : "-", nums.get(j), result);
                }
            }
        }
    }
}
