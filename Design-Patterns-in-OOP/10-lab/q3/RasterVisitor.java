public class RasterVisitor implements ShapeVisitor {
    @Override
    public void visitCircle(Circle circle) {
        System.out.println("Saving the circle... with radius= " + circle.getRadius()
                + " at position " + circle.getX() + ", " + circle.getY() + " as raster");
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        System.out.println("Saving the rectangle... with width = " + rectangle.getWidth()
                + " height = " + rectangle.getHeight() + " at position " + rectangle.getX() + ", "
                + rectangle.getY() + " as raster");
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        System.out.println("Saving the triangle... with base = " + triangle.getBase() + " height = "
                + triangle.getHeight() + " at position " + triangle.getX() + ", " + triangle.getY()
                + " as raster");
    }
}
