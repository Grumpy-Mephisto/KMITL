import java.util.Scanner;

public class FootShape {
    public static String getShapeTypeFromUser() {
        String shapeType = null;
        Scanner input = new Scanner(System.in);
        System.out.print("What to draw? 1. Ellipse, 2. Rectangle ");
        int type = input.nextInt();
        switch (type) {
            case 1:
                shapeType = "Ellipse";
                break;
            case 2:
                shapeType = "Rectangle";
                break;
        }
        input.close();
        return shapeType;
    }

    public static void main(String[] args) {
        String shapeType = getShapeTypeFromUser();
        Foot shape = null;
        switch (shapeType) {
            case "Ellipse":
                shape = new Ellipse();
                break;
            case "Rectangle":
                shape = new Rectangle();
                break;
        }
        System.out.println(shape.draw());
    }
}
