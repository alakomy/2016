package agnes;



public class Register {
	
//	variable declaration
	
	public int registerTotal;  						//holds register total
	public int change;	
	public int[] moneyQty = new int[5]; 				// hold number of bills for each domination
	public int[] moneyValue = {20, 10, 5, 2, 1}; 		// money domination
	public int moneyLeft;								//money left in register
	
	
	
	/*
	 * Constructor
	 *  Creates a new Register object
	*/
	
	public Register() {
	
	}
	
	
	/**
	 * Puts money in the register, if not all 5 numbers are entered, 0 is inserted in the place of missing number
	 * @param numOfBills
	 */
	public void initRegister(String numOfBills)  {
		
		String[] bills = numOfBills.split("\\s");
		int i = 0;
		
			for(i =0; i < bills.length; i++) {
			moneyQty[i] =  Integer.parseInt(bills[i]);
			}
		
		//get total;
		setRegisterTotal(moneyQty, moneyValue);	
	}
	
	/**
	 * @param action
	 */
	public void registerAction(String action){ 
		
		if(action.contains("put")) {
	
			this.putMoney(action);
		}
		if(action.contains("take")) {
			
			this.takeMoney(action);
		}
		if(action.contains("change")) {
			
			String newNumOfBills = stripNumberOfBillsfromActionString(action);
			change = Integer.parseInt(newNumOfBills);
			if(registerTotal > change) {
				this.calculateChange(change);
			} else {
				exitMessageForNegativeNumber();
			}
		}
		
	
	}
	
	/**
	 * puts money in a register
	 * @param numOfBills
	 */
	public void putMoney(String numOfBills) {

		String newNumOfBills = stripNumberOfBillsfromActionString(numOfBills);
		String[] bills = newNumOfBills.split("\\s");
		
		int i = 0;
		if(bills.length >= 5) {
			for(i =0; i < bills.length; i++) {
				moneyQty[i] = moneyQty[i] + Integer.parseInt(bills[i]);
			}
		}
		
		this.setRegisterTotal(moneyQty, moneyValue);	
	
	}
	
	/**
	 * takes money from register
	 * @param numOfBills
	 */
	public void takeMoney(String numOfBills){
		
		String newNumOfBills = stripNumberOfBillsfromActionString(numOfBills);
		String[] bills = newNumOfBills.split("\\s");
		
		int i = 0;
		if(bills.length >= 5) {
			for(i =0; i < bills.length; i++) {
				if(moneyQty[i] - Integer.parseInt(bills[i]) > -1) {
					moneyQty[i] = moneyQty[i] - Integer.parseInt(bills[i]);
				} else {
					exitMessageForNegativeNumber();	
				}
			}
		}
		
		this.setRegisterTotal(moneyQty, moneyValue);	
		
	}

	

	/**
	 * Calculates change, if not enough bills available or change combination cannot be made 
	 * prints out a message.
	 * @param change
	 */
	public void calculateChange(int change) {
		 int j = 0;
		 moneyLeft = 0 ;
		 
		 while(j <= 4) {
			 int currTotal = moneyValue[j];
			 int denominatioTotal = moneyQty[j];
			 int moneyper = currTotal * denominatioTotal;
			 moneyLeft += currTotal * denominatioTotal;
			 if((moneyper) > 0) {
				 
				 if (currTotal<=change) {
					 int modChange = change%currTotal;
					 
					 if(modChange > moneyValue[j+1] && (moneyValue[j+1]*moneyQty[j+1]) >= change) {
						 while(change >0 && moneyper >0) {
						 currTotal = moneyValue[j+1];
						 denominatioTotal = moneyQty[j+1];
						 moneyper = currTotal * denominatioTotal;
						 change = change - currTotal;
						 moneyper = moneyper-currTotal;
						 
						 moneyQty[j+1] = moneyQty[j+1]-1;
						 modChange = change%currTotal;
						 }
						 
					 }
					 
					 while(modChange != 1 && change >0 && moneyQty[j] >0 ) {
						 change = change- currTotal;
						 moneyper = moneyper-currTotal;

						 moneyQty[j] = moneyQty[j]-1;
						 modChange = change%currTotal;
						 
					 }  
					 if(modChange >0 && moneyper >0){
						 change = change - currTotal;
						 moneyper = moneyper-currTotal;
						 moneyQty[j] = moneyQty[j]-1;
									 
					 } 
				 } 
			 } 
			 
			 j++; 
			 
			 }
		 
		 if(change >0 ) {
			 System.out.println("Sorry no change can be given");
			 System.out.println("Bye");
			 System.exit(0);
		 }
		 
		
		 this.setRegisterTotal(moneyQty, moneyValue);

	}

	/*setters and getters*/
	
	
	public int getRegisterTotal() {
		return registerTotal;
	}


	/**
	 * @param passedMoneyQty
	 * @param passedMoneyValue
	 */
	public void setRegisterTotal(int[] passedMoneyQty, int[] passedMoneyValue) {
	
		registerTotal = 0;

		for(int i=0; i <5; i++) {
		registerTotal += passedMoneyValue[i] * passedMoneyQty[i];
		
		}
	}
	
	public int[] getMoneyQty() {
		return moneyQty;
	}

	public void setMoneyQty(int[] moneyQty) {
		this.moneyQty = moneyQty;
	}

	public int[] getMoneyValue() {
		return moneyValue;
	}

	public void setMoneyValue(int[] moneyValue) {
		this.moneyValue = moneyValue;
	}
	
	
	
	/*private methods*/
	
	
	/**
	 * @param string
	 * @return
	 */
	private String stripNumberOfBillsfromActionString(String string) {
		String [] tmpString;
		tmpString = string.split(" ", 2);
		
		string = tmpString[1];
		return string;
	}
	
	/**
	 * prints out message when there is not enough bills
	 */
	private static void exitMessageForNegativeNumber(){
		System.out.println("Sorry, not enough bills");
		System.out.println("Bye");
		System.exit(0);
	}
	

}
