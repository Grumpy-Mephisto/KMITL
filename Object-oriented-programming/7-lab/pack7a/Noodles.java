package pack7a;

public class Noodles extends Product {
    public Noodles(String n, String d) {
        super(n, d);
    }

    @Override
    public String toString() {
        return "ProductName=" + pName + ", desc=" + desc + "]";
    }
}
