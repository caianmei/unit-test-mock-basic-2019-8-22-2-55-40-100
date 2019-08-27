package cashregister;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PurchaseTest {
	
	@Test
	void should_return_item_name_and_price_string_when_as_string_given_mock_item() {
		//given
		Item item = mock(Item.class);
		Item[] items = new Item[] {item};
		Purchase purchase = new Purchase(items);
		when(items[0].getName()).thenReturn("name");
		when(items[0].getPrice()).thenReturn(2.0);
		//when
		
		//then
		assertEquals("name\t2.0\n", purchase.asString());
	}
	
	@Test
	void should_return_item_name_and_price_when_as_string_given_mock_item() {
		//given
		Item[] items = new Item[1];
		items[0] = mock(Item.class);
		Purchase purchase = new Purchase(items);
		//when
		purchase.asString();
		//then
		for (Item item : items) {
			verify(item).getName();
			verify(item).getPrice();
		}		
	}

}
