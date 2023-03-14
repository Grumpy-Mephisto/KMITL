import pack7a.*;

public class Test7Basket {
    public static void main(String[] args) {
        Shop csShop = new Shop("CS-groceries");
        String picking;

        System.out.println("1-------------");
        Basket b1 = csShop.newCustomerArrives();
        picking = "mama";
        b1.putInBasket(csShop.generateLineItem(picking, 1));
        picking = "lactasoy";
        b1.putInBasket(csShop.generateLineItem(picking, 2));
        b1.showItemsInBasket();

        Basket b2 = csShop.newCustomerArrives();
        picking = "mix veggies";
        b2.putInBasket(csShop.generateLineItem(picking, 3));
        picking = "korean";
        b2.putInBasket(csShop.generateLineItem(picking, 4));
        b2.showItemsInBasket();

        System.out.println("2-------------");
        csShop.getPayment(b1);
        csShop.getPayment(b2);

        System.out.println("3-------------");
        b2 = csShop.newCustomerArrives();
        picking = "mama";
        b2.buyNow(csShop.generateBuyNowItem(picking));
        // csShop.dailySalesReport();
    }
}