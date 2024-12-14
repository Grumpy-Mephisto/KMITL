import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Foot foot = new Foot();
        Scanner scanner = new Scanner(System.in);
        System.out.print("What to draw? 1. Ellipse, 2. Rectangle ");
        int type = scanner.nextInt();
        scanner.close();

        FootShape shape = FootShape.getShape(type);
        foot.draw(shape);
    }
}
