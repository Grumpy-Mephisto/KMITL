import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		List<Shape> shapes = new ArrayList<>();
		shapes.add(new Circle(5.5, 200, 100));
		shapes.add(new Triangle(4, 5, 500, 1000));
		shapes.add(new Rectangle(6, 8, 400, 720));
	}
}
