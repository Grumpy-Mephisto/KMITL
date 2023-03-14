package pack7a;

import java.util.ArrayList;
import java.util.Map;

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
    }

    public Basket newCustomerArrives() {
        return null;
    }

    public LineItem generateLineItem(String pName, int q) { // add to UML
        return null;
    }

    public LineItem generateBuyNowItem(String pName) {
        return null;
    }

    public void getPayment(Basket b) {

    }

    public void dailySalesReport() {

    }

}
