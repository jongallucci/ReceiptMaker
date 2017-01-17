import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.*;

public class ReceiptMaker{

	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);	//setup to read user inputs
		String itemBought = "";
		List<String> itemList = new ArrayList<String>();	//list of all items bought by user
		
		System.out.println("Enter items bought, write 'end' when done: ");
		while(!itemBought.equals("end")){
			itemBought = reader.nextLine();		//reads user inputs and stores them
			itemList.add(itemBought);			//adds items to list
		}
		itemList.remove(itemList.size()-1);		//removes 'end' from list
		
		List<String> itemPrices = new ArrayList<String>();	//list of prices of items
		for(int i =0; i < itemList.size(); i++){
			String item = itemList.get(i);
			double price = Math.round(Math.random()*item.length())+0.99;	//price determined by randomness and length of item name
			itemPrices.add(Double.toString(price));		//adds price to price list
		}
		
		double total = 0;						//total price of all items
		System.out.println("\n\n\nHere is your receipt:\n");
		
		for(int i = 0; i < itemList.size(); i++){		//print out item with corresponding price, and add total up
			System.out.println(itemList.get(i) + "\t\t$" + itemPrices.get(i));
			total += Double.parseDouble(itemPrices.get(i));
		}
				//print receipt out nice and pretty
		System.out.println("\nSubtotal:\t$" + Double.toString(total) + "\nHST: \t\t$" + Double.toString(((double)Math.round(total*13))/100));
		System.out.println("Your total:\t$" + Double.toString(total+(double)Math.round(total*13)/100));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("     Thank You!");
	}
}