import java.util.*;

class receiveValue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int value = 1;
        int totalEven = 0;
        
        while (value > 0) {
            System.out.print("Enter Value  => ");
            value = scan.nextInt();
            if (value % 2 == 0){
                totalEven += value;
            }
        }
        System.out.printf("Result of Summary Even Numbers = %d", totalEven);
        scan.close();
    }
}