import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FootShape footShape = new FootShape();

        System.out.print("What to draw? 1. Ellipse, 2. Rectangle ");
        int choice = scanner.nextInt();

        String result;
        if (choice == 1) {
            result = footShape.drawAsEllipse();
        } else if (choice == 2) {
            result = footShape.drawAsRectangle();
        } else {
            result = "Invalid choice";
        }

        System.out.println(result);
        scanner.close();
    }
}
