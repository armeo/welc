package pointofsale;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class InventoryTest {

    @Test
    public void shouldReturnItemNotFoundDescriptionWhenBarcodeNotFound() {
        Inventory inventory = new Inventory();

        assertThat(inventory.itemForBarcode("11").getName(), is("Item not found"));
    }
}
