package pack7a;

import java.util.ArrayList;

public class Shop {

  private String name;
  private Catalog catalog = new Catalog();
  private ArrayList<Basket> ordersToday = new ArrayList<>();

  public Shop(String n) {
    name = n;
    catalog.add(new Drink("mix veggies", "refreshing"), 22);
    catalog.add(new Drink("lactasoy", "less hungry"), 15);
    catalog.add(new Noodles("mama", "classic"), 9);
    catalog.add(new Noodles("korean", "i can afford"), 33);
    // duplicate won't update
    catalog.add(new Noodles("mama", "duplicate"), 11);
    showCatalog();
  }

  private void showCatalog() {
    System.out.println("Welcome to " + name);
    catalog.showCatalog();
  }

  public Basket newCustomerArrives() {
    Basket newBasket = new Basket();
    ordersToday.add(newBasket);
    return newBasket;
  }

  public LineItem generateLineItem(String pName, int q) { // add to UML
    Product product = catalog.getProduct(pName);
    LineItem newLineItem = new LineItem(product, q, catalog.getPrice(pName));
    return newLineItem;
  }

  public LineItem generateBuyNowItem(String pName) {
    Product product = catalog.getProduct(pName);
    LineItem lineItem = new LineItem(product, 1, catalog.getPrice(pName));
    return lineItem;
  }

  public void getPayment(Basket b) {
    System.out.println("I am cashier");
    b.printInvoice();
  }

  public void dailySalesReport() {
    int grandTotal = 0;

    for (Basket item : ordersToday) {
      item.showItemsInBasket();
      grandTotal += item.grandTotalOrder();
    }

    System.out.println("Grand Total: " + grandTotal);
  }
}
