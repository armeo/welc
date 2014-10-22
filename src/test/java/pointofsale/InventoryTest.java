package pointofsale;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class InventoryTest {

    Item toldItem;

    @Test
    public void itemIsTold(){
        Inventory inventory = new Inventory();

        inventory.item("3", new Told<Item>(){
           public void tell(Item item){
               toldItem = item;
           }
        });

        assertThat(toldItem.getName(), is("Milk"));
    }
}
