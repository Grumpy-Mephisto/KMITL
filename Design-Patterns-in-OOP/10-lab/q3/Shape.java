public abstract class Shape {
	protected int x;
	protected int y;

	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	// This method will be implemented by each concrete shape
	public abstract void accept(ShapeVisitor visitor);
}
