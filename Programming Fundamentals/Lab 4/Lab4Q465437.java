import java.util.*;

public class Lab4Q465437 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i, number, summary = 0;
        // String result = "";
        boolean result = false;

        System.out.print("Enter number => ");
        number = scan.nextInt();
        scan.close();
        
        for(i = 1; i <= number/2 + 1; i++) {
            if(number % i == 0){
                System.out.printf("%d%n", i);
                System.out.println("-----");
                summary += i;
            }
            result = summary == number ? true : false;
        }
        System.out.print(result);
    }
}
