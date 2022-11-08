class Coin_50437 {

  public static void main(String[] args) {
    Coin coin = new Coin();
    System.out.println(coin);
    System.out.println("Area of coin is " + coin.getArea());
    System.out.println("Circumference of coin is " + coin.getCircumference());
    coin.setColor("blue");
    System.out.println("Color of coin is " + coin.getColor());
    coin.flip();
    System.out.println("Color of coin is " + coin.getColor());
    coin.flip();
    System.out.println("Color of coin is " + coin.getColor());
    coin.setColor("blue");
    System.out.println("Color of coin is " + coin.getColor());
    coin.flip();
    System.out.println("Color of coin is " + coin.getColor());
  }
}

class Coin {

  String colorHead;
  String colorTail;
  double radius;
  int face = 0;

  Coin() {
    radius = 1.0;
    colorHead = "red";
    colorTail = "red";
  }

  Coin(double radius) {
    this.radius = radius;
  }

  double getRadius() {
    return radius;
  }

  void setRadius(double radius) {
    this.radius = radius;
  }

  double getArea() {
    return Math.PI * Math.pow(radius, 2);
  }

  double getCircumference() {
    return radius * 2 * Math.PI;
  }

  String getColor() {
    if (face == 0) {
      return "colorHead = " + this.colorHead;
    } else return "colorTail = " + this.colorTail;
  }

  void setColor(String Color) {
    if (face == 0) {
      this.colorHead = Color;
    } else this.colorTail = Color;
  }

  void flip() {
    face = (face == 0) ? 1 : 0;
  }

  public String toString() {
    return "Circle [ radius = " + radius + " ]";
  }
}
