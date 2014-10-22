package pointofsale;

public class UnfoundedItem extends Item {

    public UnfoundedItem() {
        super("Item not found", new Money(0));
    }
}
