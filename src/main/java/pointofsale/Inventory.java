package pointofsale;

import java.util.HashMap;


public class Inventory {
    private HashMap<String, Item> items = new HashMap<String, Item>();

    public Inventory() {
        Item milk = new Item("Milk", new Money(7000));
        items.put("1", new Item("Preserved Duck Eggs", new Money(150000)));
        items.put("3", milk);
        items.put("4", new Coupon(milk, new Money(10)));
    }

    public void item(String barcode, Told<Item> told) {
        Item item = items.get(barcode);
        if(item != null)
            told.tell(item);
    }
}