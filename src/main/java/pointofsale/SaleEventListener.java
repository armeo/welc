package pointofsale;

public interface SaleEventListener {
    public void itemAdded(Item item);

    public void subtotaled(Money subtotal);

    public void totalled(Money total);
}
