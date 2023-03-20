package pack7a;

import java.util.ArrayList;

public class Basket {

  private ArrayList<LineItem> items = new ArrayList<>();

  public void showItemsInBasket() {
    System.out.println("This basket contains");

    for (LineItem item : items) {
      System.out.println(item);
    }
  }

  public void putInBasket(LineItem item) {
    items.add(item);
  }

  public int grandTotalOrder() {
    int sum = 0;
    for (LineItem line : items) {
      sum += line.calculateAmount();
    }
    return sum;
  }

  public void printInvoice() {
    System.out.println("invoice header");
    int sum = 0;
    for (LineItem line : items) {
      System.out.println(
        line.getProduct().getpName() +
        " x " +
        line.getQuantity() +
        " [ " +
        line.calculateAmount() +
        " ]"
      );
      sum += line.calculateAmount();
    }
    System.out.printf("==== Total is %d ====%n", sum);
  }

  public void buyNow(LineItem item) {
    putInBasket(item);
    Product product = item.getProduct();

    System.out.println("invoice header");
    System.out.printf(
      "%s x %d %d%n",
      product.pName,
      item.getQuantity(),
      item.calculateAmount()
    );
    System.out.printf("==== Total is %d ====%n", item.calculateAmount());
  }
}
