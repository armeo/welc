package pointofsale;

import static org.junit.Assert.*;

import java.text.NumberFormat;

import org.junit.Before;
import org.junit.Test;


class FakeDisplay implements Display
{
	String lastShownLine;
	
	public void showLine(String line) {
		lastShownLine = line;
	}
}

class FakeListener implements SaleEventListener
{
	Item lastItem;
	Money lastSubtotal;
	Money lastTotal;
	
	public void itemAdded(Item item) {	
		lastItem = item;
	}

	public void subtotaled(Money subtotal) {	
		lastSubtotal = subtotal;
	}

	public void totalled(Money total) {		
		lastTotal = total;
	}
}

public class SaleTest {
	FakeDisplay display;
	SaleDisplay listener;
	Sale sale;

	@Before
	public void setUp() {
		display = new FakeDisplay();
		listener = new SaleDisplay(display);
		sale = new Sale(listener);
	}
	
	@Test
	public void canSellPreservedDuckEggs() {
		FakeListener listener = new FakeListener();
		sale = new Sale(listener);
		sale.addBarcode("1");
		assertEquals(150000, listener.lastItem.getPrice().getCents());
		assertEquals("Preserved Duck Eggs", listener.lastItem.getName());
	}
	
	@Test
	public void canSellMilk() {
		sale.addBarcode("3");
		assertEquals("Milk $70.00", display.lastShownLine);	
	}
	
	@Test
	public void canSellMilkWithCoupon() {
		sale.addBarcode("3");
		sale.addBarcode("4");   // Coupon for Milk
		assertEquals("Coupon for Milk ($0.10)", display.lastShownLine);	
	}
	
	@Test
	public void canSubtotalASale() {
		sale.addBarcode("1");
		sale.addBarcode("3");
		sale.subtotal();
		assertEquals("Subtotal $1,570.00", display.lastShownLine);	
	}
	
	@Test
	public void canTotalASale() {
		sale.addBarcode("3");
		sale.total();
		assertEquals("Total $70.00", display.lastShownLine);	
	}

}
