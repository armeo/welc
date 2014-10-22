package pointofsale;

import org.junit.Assert;
import org.junit.Test;



public class ItemTest {
	
	@Test
	public void canGenerateDisplayLine() {
		Assert.assertEquals("Milk $70.00", new Item("Milk", new Money(7000)).getDisplayLine());
	}

}
