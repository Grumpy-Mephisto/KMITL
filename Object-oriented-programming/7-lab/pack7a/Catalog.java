package pack7a;

import java.util.HashMap;
import java.util.Map;

public class Catalog {
    private Map<String, Product> productList;
    private Map<String, Integer> priceList;

    public Catalog() {
        productList = new HashMap<>();
        priceList = new HashMap<>();
    }

    public void add(Product product, int price) {

    }

    public void showCatalog() {

    }

    public int getPrice(String productName) {
        return 0;
    }

    public Product getProduct(String productName) {
        return null;
    }
}
