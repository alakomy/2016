package agnes.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import agnes.Register;

public class CashRegisterTest
{

    private Register cashRegister;


    @Before
    public void setUpRegister()
    {
        cashRegister = new Register();
        System.out.println("Adding to register number of bills  1 2 3 4 5 \n");
        cashRegister.initRegister("1 2 3 4 5");
      
        
    }


    // ----------------------------------------------------------
    /**
     * Test Register Actions
     * 
     */

    @Test
    public void aTestRegisterAction()
    {

    	assertEquals(68, cashRegister.getRegisterTotal());
    	
    	System.out.println("Total $"+cashRegister.registerTotal + " " 
    						+ cashRegister.moneyQty[0] + " " +cashRegister.moneyQty[1] + " " 
    						+ cashRegister.moneyQty[2] + " " + cashRegister.moneyQty[3] + " "
    						+ cashRegister.moneyQty[4]  + "\n");
       
    	
    	System.out.println("put 1 2 3 0 5 \n");
    	cashRegister.registerAction("put 1 2 3 0 5");
        assertEquals(128, cashRegister.getRegisterTotal());
        
        System.out.println("Total $"+cashRegister.registerTotal + " " 
				+ cashRegister.moneyQty[0] + " " +cashRegister.moneyQty[1] + " " 
				+ cashRegister.moneyQty[2] + " " + cashRegister.moneyQty[3] + " "
				+ cashRegister.moneyQty[4]  + "\n");
        
        
        System.out.println("take 1 4 3 0 10 \n");
        cashRegister.registerAction("take 1 4 3 0 10");
        assertEquals(43, cashRegister.getRegisterTotal());
        
        
        System.out.println("Total $"+cashRegister.registerTotal + " " 
				+ cashRegister.moneyQty[0] + " " +cashRegister.moneyQty[1] + " " 
				+ cashRegister.moneyQty[2] + " " + cashRegister.moneyQty[3] + " "
				+ cashRegister.moneyQty[4]  + "\n");
        
        System.out.println("change 11 \n");
        
        cashRegister.registerAction("change 11");
        assertEquals(32, cashRegister.getRegisterTotal());
        
        System.out.println("Total $"+cashRegister.registerTotal + " " 
				+ cashRegister.moneyQty[0] + " " +cashRegister.moneyQty[1] + " " 
				+ cashRegister.moneyQty[2] + " " + cashRegister.moneyQty[3] + " "
				+ cashRegister.moneyQty[4]  + "\n");
        
        
        System.out.println("change 14 \n");
        cashRegister.registerAction("change 14");
        assertEquals(32, cashRegister.getRegisterTotal());
        
        System.out.println("Total $"+cashRegister.registerTotal + " " 
				+ cashRegister.moneyQty[0] + " " +cashRegister.moneyQty[1] + " " 
				+ cashRegister.moneyQty[2] + " " + cashRegister.moneyQty[3] + " "
				+ cashRegister.moneyQty[4]  + "\n");
 
    }
    
    
}


