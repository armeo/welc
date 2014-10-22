package pointofsale;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class InventoryTest {

    @Test
    public void shouldReturnNullWhenBarcodeNotFound(){
        Inventory inventory = new Inventory();

        assertThat(inventory.itemForBarcode("11"), is(nullValue()));
    }
}
