import java.util.*;

class Factorial {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int factorial = 1;
        for(int i = 1; i <= number; i++) {
            factorial *= i;
        }

        System.out.printf("Factorial of %d is ", number);        
        System.out.print(RED + factorial + RESET);
        input.close();
        
    }
}