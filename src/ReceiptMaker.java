import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class ReceiptMaker{

	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);	//setup to read user inputs
		String itemBought = "";
		///////////////
		String fileName = "ItemsPrice.txt";
		String line = null;
		List<List<String>> itemsWithPricesList = new ArrayList<List<String>>();
		
		  try{
	            FileReader fileReader = new FileReader(fileName);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);

	            while((line = bufferedReader.readLine()) != null)
	            	System.out.println(line);
	                

	            bufferedReader.close();         
	        }
	        catch(FileNotFoundException ex){
	            System.out.println(
	                "Unable to open file '" + 
	                fileName + "'");                
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + fileName + "'");
	            // Or we could just do this: 
	            // ex.printStackTrace();
	        }
		
		///////////////
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
			float price = (float)(Math.round(Math.random()*item.length())+0.99);	//price determined by randomness and length of item name
			itemPrices.add(Float.toString(price));		//adds price to price list
		}
		
		float total = 0;								//total price of all items
		System.out.println("\n\n\nHere is your receipt:\n");
		
		for(int i = 0; i < itemList.size(); i++){		//print out item with corresponding price, and add total up
			System.out.println(itemList.get(i) + "\t\t$" + itemPrices.get(i));
			total += Float.parseFloat(itemPrices.get(i));
		}
		
				//print receipt out nice and pretty
		double hst = total*0.13;						//calculates the taxes on purchases
		double finalTotal = total+(total*0.13);			//calculates final total due
		System.out.printf("\nSubtotal:\t$%.2f%n", total);
		System.out.printf("HST: \t\t$%.2f%n", hst);
		System.out.printf("Your total:\t$%.2f%n",finalTotal);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~\n      Thank You!");
	}
}