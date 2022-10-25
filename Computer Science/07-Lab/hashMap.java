import java.util.HashMap;

class hashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> menu = new HashMap<>();
        menu.put("Punch", 10);
        menu.putIfAbsent("Espresso", 15);
        menu.putIfAbsent("Lemon Tea", 19);
        System.out.println("Listing menu content");
        int i = 0;
        for (var entry : menu.entrySet()) {
            // for (Map.Entry<String, Integer> entry :menu.entrySet()) {
            String itemName = entry.getKey();
            int price = entry.getValue();
            System.out.println("item " + ++i + " " + itemName + " " + price);
        }

        System.out.println("Listing only menu names");
        
        /* Q1 */
        for (var entry : menu.entrySet()) {
            System.out.println(entry.getKey());
        }
        ///////////////////////////////////////////

        System.out.println("Listing only menu prices");

        /* Q2 */
        for (var entry : menu.entrySet()) {
            System.out.println(entry.getValue());
        }
        ///////////////////////////////////////////

        Order[] table1 = { new Order("Lemon Tea", 2),
        new Order("Punch", 3) };
        System.out.println("To access order detail use .");
        System.out.print("e.g. table1[0].item " + table1[0].item + " and ");
        System.out.println(table1[0].quantity);
        System.out.print("Table1's amount due is ");
        int amount = 0;

        /* Q3 */
        for (var order : table1) {
            amount += order.quantity;
        }
        ///////////////////////////////////////////

        System.out.println(amount);
    }
}

class Order {
    String item; int quantity;

    Order(String i, int q) {
        item = i;
        quantity = q;
    }
}

// Author: 65050437