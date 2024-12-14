import java.util.Scanner;

public class FootShape {


    public static String drawAsEllipse() {
        return new Ellipse().draw();
    }

    public static String drawAsRectangle() {
        return new Rectangle().draw();
    }

    public static void main(String[] args) {
        String shapeType = null;
        Scanner input = new Scanner(System.in);
        System.out.print("Please choose shape type 1. Ellipse, 2. Rectangle ");
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

        String shape = null;
        switch (shapeType) {
            case "Ellipse":
                shape = drawAsEllipse();
                break;
            case "Rectangle":
                shape = drawAsRectangle();
                break;
        }
        System.out.println(shape);
    }
}
