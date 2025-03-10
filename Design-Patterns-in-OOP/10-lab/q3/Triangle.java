public class Triangle extends Shape {
	private int base;
	private int height;

	public Triangle(int base, int height, int x, int y) {
		super(x, y);
		this.base = base;
		this.height = height;
	}

	public int getBase() {
		return base;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public void accept(ShapeVisitor visitor) {
		visitor.visitTriangle(this);
	}
}
