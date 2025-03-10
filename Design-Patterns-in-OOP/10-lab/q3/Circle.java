public class Circle extends Shape {
	private double radius;

	public Circle(double radius, int x, int y) {
		super(x, y);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public void accept(ShapeVisitor visitor) {
		visitor.visitCircle(this);
	}
}
