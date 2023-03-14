package pack7a;

public class LineItem {
    private Product product;
    private int quantity;
    private int buyPrice;

    public LineItem(Product prod, int q, int p) {
        product = prod;
        quantity = q;
        buyPrice = p;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int calculateAmount() {
        return 0;
    }

    @Override
    public String toString() {
        return quantity + " of " + product.getpName() + " @= " + buyPrice;
    }
}
