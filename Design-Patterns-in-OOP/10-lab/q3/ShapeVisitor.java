public interface ShapeVisitor {
    void visitCircle(Circle circle);

    void visitRectangle(Rectangle rectangle);

    void visitTriangle(Triangle triangle);
}
