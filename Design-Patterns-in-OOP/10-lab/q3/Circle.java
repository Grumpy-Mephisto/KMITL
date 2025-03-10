public class Circle extends Shape {
	private double radius;

	public Circle(double radius, int x, int y) {
		this.radius = radius;
		super.setxPos(x);
		super.setyPos(y);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
}
