import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Ex2WithSRP {
    public static final int MAX = 5;
    private static Scanner input = new Scanner(System.in);

    /**
     * Single Responsibility Principle (SRP)
     *
     * @method 1. getInputNumbers() - Get 5 valid integers in the range [0, 10]
     * @method 2. getUserInput() - Get user input
     * @method 3. isValidInteger() - Check if the input is a valid integer
     * @method 4. isValidRange() - Check if the input is in the range [0, 10]
     * @method 5. sortNumbers() - Sort the list of numbers
     * @method 6. displayNumbers() - Display the sorted numbers
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Application!");
        System.out.println("Enter 5 valid integers in the range [0, 10]");

        List<Integer> nums = getInputNumbers();
        nums = sortNumbers(nums);
        displayNumbers(nums);

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
}
