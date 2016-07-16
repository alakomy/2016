package agnes.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import agnes.Register;

public class BonusCaseTest {
	
	 private Register cashRegister;
	 
	 
	 @Before
	 public void setUpRegister()
	 {
		 cashRegister = new Register();
		 System.out.println("Adding to register number of bills  1 2 3 4 5 \n");
		 cashRegister.initRegister("0 0 1 4 0");
	        
		 System.out.println("Total $"+cashRegister.registerTotal + " " 
	    			+ cashRegister.moneyQty[0] + " " +cashRegister.moneyQty[1] + " " 
	    			+ cashRegister.moneyQty[2] + " " + cashRegister.moneyQty[3] + " "
	    			+ cashRegister.moneyQty[4]  + "\n");
	      
	        
	 }

	@Test
	public void bonusTest() {

		System.out.println("change 8 \n");
		cashRegister.registerAction("change 8");
		assertEquals(5, cashRegister.getRegisterTotal());
    
		System.out.println("Total $"+cashRegister.registerTotal + " " 
				+ cashRegister.moneyQty[0] + " " +cashRegister.moneyQty[1] + " " 
				+ cashRegister.moneyQty[2] + " " + cashRegister.moneyQty[3] + " "
				+ cashRegister.moneyQty[4]  + "\n");
	}


}
