package agnes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*Cash Register program calculates number of bills in each denomination
*/
public class CashRegister {
	
	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner (System.in);
		BufferedReader x = new BufferedReader (new InputStreamReader(System.in));
		Register register = new Register();
		 
		System.out.print("Please enter number of bills for each denomination (#$20 #$10 #$5 #$2 #$1) : ");
		
		String inputline = x.readLine();
		register.initRegister(inputline);
		
		//print out grand total and number of bills
		grandTotalMsg(register);
    

		System.out.println("Enter action you would like to perform (put, take, change) in each denomination #$20 #$10 #$5 #$2 #$1");
		System.out.println(" -->");
		
		while(scanner.hasNext()) {		
			inputline = scanner.nextLine();
			register.registerAction(inputline);
			
			//print out grand total and number of bills
			grandTotalMsg(register);
			
		    }
			
		}
		
	
	
	private static void grandTotalMsg(Register register) {
		
		 System.out.println("Total $"+ register.registerTotal + " " 
					+ register.moneyQty[0] + " " +register.moneyQty[1] + " " 
					+ register.moneyQty[2] + " " + register.moneyQty[3] + " "
					+ register.moneyQty[4]  + "\n");
		
	}
	
	

}
