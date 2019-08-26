package cashregister;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
    	Printer printer = new Printer();
    	CashRegister cashRegister = new CashRegister(printer);
    	Item[] items = new Item[1];
    	items[0] = new Item("item1", 1);
    	Purchase purchase = new Purchase(items);
        //when
    	String message = null;
    	try {
    		cashRegister.process(purchase);	
		} catch (Exception e) {
			message = e.getMessage();
		}
    		
        //then
    	assertEquals("Not Implemented", message);
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
    	//given
    	String[] message = new String[1];
    	Printer printer = new Printer() {
    		@Override
    		public void print(String printThis) {
    			message[0] = printThis;
    		}
    	};
    	CashRegister cashRegister = new CashRegister(printer);
    	Item[] items = new Item[1];
    	items[0] = new Item("name", 1);
    	Purchase purchase = new Purchase(items);
    	
    	String expected = "";
    	for (Item item : items) {
    		expected += item.getName() + "\t" + item.getPrice() + "\n";
        }
        //when
    	cashRegister.process(purchase);	
    		
        //then
    	assertEquals(expected, message[0]);
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
    	Printer printer = mock(Printer.class);
    	Purchase purchase = mock(Purchase.class);
    	CashRegister cashRegister = new CashRegister(printer);
    	when(purchase.asString()).thenReturn("I can return");
        //when
    	cashRegister.process(purchase);
        //then
    	verify(printer).print("I can return");
    }

}
