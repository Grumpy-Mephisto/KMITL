import java.util.*;

public class Lab4Q265437 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countProducts = 0;        
        int summaryPrice = 0;
        int firstMaxPrice = 0; int secondMaxPrice = 0;

        while (countProducts < 3) {
            System.out.print("What is the product price? \n=> ");
            int newPrice = scan.nextInt();

            
            if(newPrice > firstMaxPrice){
                secondMaxPrice = firstMaxPrice;
                firstMaxPrice = newPrice;
            } else if (newPrice > secondMaxPrice) {
                secondMaxPrice = newPrice;
            }
            
            summaryPrice = firstMaxPrice + secondMaxPrice;
            countProducts ++;
        }
        System.out.printf("\n----- Price you have to pay => %d -----", summaryPrice);
        scan.close();
    }
}
