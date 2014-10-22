package pointofsale;

import java.util.List;


public class Coupon extends Item {
    private Item itemFor;

    public Coupon(Item itemFor, Money amount) {
        super("Coupon for " + itemFor.getName(), amount.negate());
        this.itemFor = itemFor;
    }

    public Money getPrice(List<Item> items) {
        for (Item item : items) {
            if (item.getName().equals(itemFor.getName())) return super.getPrice();
        }
        return new Money(0);
    }

    public Money getTaxedPrice(List<Item> items) {
        for (Item item : items) {
            if (item.getName().equals(itemFor.getName())) return super.getTaxedPrice();
        }
        return new Money(0);

    }
}
