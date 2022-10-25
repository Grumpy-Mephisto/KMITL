import java.util.*;

public class convertTemp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Temperature In Fahrenheit  => ");
        int tempF = scan.nextInt();
        scan.close();
        
        int tempC = (tempF - 32)* 5 / 9;
        System.out.printf("Temperature In Celsius = %d", tempC);
    }
}