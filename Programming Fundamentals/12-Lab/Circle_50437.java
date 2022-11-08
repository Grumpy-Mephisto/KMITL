class Circle_50437 {

  public static void main(String[] args) {
    Circle circle = new Circle();
    double area = circle.getArea();
    double circumference = circle.getCircumference();

    System.out.println(circle);
    System.out.println(
      "Area of circle is " + area + " and circumference is " + circumference
    );

    circle.setRadius(5);
    area = circle.getArea();
    circumference = circle.getCircumference();
    System.out.println(circle);
    System.out.println(
      "Area of circle is " + area + " and circumference is " + circumference
    );
  }
}

class Circle {

  double radius;

  // Class constructor
  Circle() {
    // Q1
    radius = 1.0; // default radius
  }

  // Class constructor
  Circle(double radius) {
    // Q2
    this.radius = radius;
  }

  // Q3
  double getRadius() {
    return radius;
  }

  // Q4
  void setRadius(double radius) {
    this.radius = radius;
  }

  double getArea() {
    // Q5
    return Math.PI * radius * radius;
  }

  double getCircumference() {
    return 2 * Math.PI * radius;
  }

  public String toString() {
    return "Circle [ radius = " + radius + " ]";
  }
}
