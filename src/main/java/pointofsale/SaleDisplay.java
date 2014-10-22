package pointofsale;

import java.text.NumberFormat;

class SaleDisplay implements SaleEventListener
{
	private Display display;
	
	public SaleDisplay(Display display) {
		this.display = display;
	}
	
	public void itemAdded(Item item) {	
		display.showLine(item.getDisplayLine());
	}

	public void subtotaled(Money subtotal) {		
		display.showLine("Subtotal " + subtotal.asText());
	}
	
	public void totalled(Money total) {		
		display.showLine("Total " + total.asText());

	}
}
