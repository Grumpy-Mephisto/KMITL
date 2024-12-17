import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Ex2 {
    public static final int MAX = 5;

    public static void main(String[] args) {
        System.out.println("Welcome to the Application!");

        List<Integer> nums = new ArrayList<>();
        while (nums.size() < MAX) {
            // รับข้อมูลเข้า
            String input = readInput();

            // ตรวจสอบประเภทข้อมูล
            if (!validateDataType(input)) {
                System.out.println("Invalid! Try again!");
                continue;
            }

            int num = Integer.parseInt(input);

            // ตรวจสอบช่วง
            if (!validateRange(num)) {
                System.out.println("Invalid range! Try again!");
                continue;
            }

            nums.add(num);
        }

        // จัดเรียง
        List<Integer> sortedNums = sortNumbers(nums);

        // แสดงผล
        displayResult(sortedNums);
    }

    // ฟังก์ชันรับข้อมูลเข้า
    private static String readInput() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter 5 valid integers in the range [0, 10]");
        String input = inp.nextLine();
        inp.close();
        return input;
    }

    // ฟังก์ชันตรวจสอบประเภทข้อมูล
    private static boolean validateDataType(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    // ฟังก์ชันตรวจสอบช่วง
    private static boolean validateRange(int num) {
        return num >= 0 && num <= 10;
    }

    // ฟังก์ชันจัดเรียง
    private static List<Integer> sortNumbers(List<Integer> nums) {
        List<Integer> sorted = new ArrayList<>(nums);
        Collections.sort(sorted);
        return sorted;
    }

    // ฟังก์ชันแสดงผล
    private static void displayResult(List<Integer> nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
