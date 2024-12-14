public class FootShape {
    public void draw() {
        System.out.println("Drawing a foot shape");
    }

    public static FootShape getShape(int type) {
        switch (type) {
            case 1:
                return new Ellipse();
            case 2:
                return new Rectangle();
            default:
                return null;
        }
    }
}
