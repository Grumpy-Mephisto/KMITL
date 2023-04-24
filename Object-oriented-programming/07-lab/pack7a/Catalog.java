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
    if (!product.getDesc().equals("duplicate")) {
      productList.put(product.getpName(), product);
      priceList.put(product.getpName(), price);
    }
  }

  public void showCatalog() {
    for (Map.Entry<String, Product> entry : productList.entrySet()) {
      String itemName = entry.getKey();
      System.out.printf("%s [ %d ]%n", itemName, priceList.get(itemName));
    }
  }

  public int getPrice(String productName) {
    return priceList.get(productName);
  }

  public Product getProduct(String productName) {
    return productList.get(productName);
  }
}
