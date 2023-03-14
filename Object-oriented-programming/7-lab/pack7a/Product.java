package pack7a;

public abstract class Product {
    protected String pName;
    protected String desc;

    public Product(String n, String d) {
        pName = n;
        desc = d;
    }

    public String getpName() {
        return pName;
    }

    public String getDesc() {
        return desc;
    }
}
