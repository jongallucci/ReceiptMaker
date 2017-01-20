import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class ReceiptMaker{
	// Read from file
	private static void readFile( String fileName, ArrayList<String> names, ArrayList<String> prices){
		String line = null;
		
		try{
	        FileReader fileReader = new FileReader(fileName);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	
	        while((line = bufferedReader.readLine()) != null){
	        	String[] parts = line.split(",");
	        	names.add( parts[0]);
	        	prices.add( parts[1]);
		    }
		    bufferedReader.close();         
		}
		catch(FileNotFoundException ex){
		    System.out.println( "Unable to open file '" + fileName + "'");                
		}
		catch(IOException ex){
		    System.out.println( "Error reading file '" + fileName + "'");
		}
	}
	
	// Read from file
	private static void writeFile( String fileName, String name, String price){
		String line = null;
		
		try(FileWriter fw = new FileWriter("outfilename", true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		{
			String lineOut = name + "," + price;
		    out.println(lineOut);
		} catch (IOException e) {
			System.out.println("ERROR");
		}
	}

	// Main, program starts here
	public static void main(String[] args){
		ArrayList<String> fileItemNames = new ArrayList<String>();
		ArrayList<String> fileItemPrices = new ArrayList<String>();
		
		Scanner reader = new Scanner(System.in);	//setup to read user inputs
		
		readFile( "ItemsPrice.txt", fileItemNames, fileItemPrices); // Load file
		
		List<String> itemList = new ArrayList<String>();	//list of all items bought by user
		String itemBought = "";
		System.out.println("Enter items bought, write 'end' when done: ");
		while(!itemBought.equals("end")){
			itemBought = reader.nextLine();		//reads user inputs and stores them
			itemList.add(itemBought);			//adds items to list
		}
		itemList.remove( itemList.size() - 1);		//removes 'end' from list
		reader.close();
		
		
		// Checking for valid items
		List<String> itemPrices = new ArrayList<String>();	//list of prices of items
		for(int i = 0; i < itemList.size(); i++){
			String item = itemList.get(i);
			if( fileItemNames.contains(item)){
				itemPrices.add(fileItemPrices.get(fileItemNames.indexOf(item)));		//adds price to price list
			}
			else{
				// Get user input to add
				System.out.printf("%s is not a valid item. Please enter a price\n", item);
				
				Scanner input_reader = new Scanner(System.in);  // Reading from System.in
				System.out.print ("Pls enter somehting" );
				String input = input_reader.nextLine();
				input_reader.close();
				
				writeFile( "ItemsPrice.txt", item, input);
			}
		}
		
		
		// Get total price
		float total = 0;								//total price of all items
		System.out.println("\n\n\nHere is your receipt:\n");
		for(int i = 0; i < itemList.size(); i++){		//print out item with corresponding price, and add total up
			System.out.println(itemList.get(i) + "\t\t$" + itemPrices.get(i));
			total += Float.parseFloat(itemPrices.get(i));
		}
		
		
		// Print receipt out nice and pretty
		double hst = total*0.13;						//calculates the taxes on purchases
		double finalTotal = total+(total*0.13);			//calculates final total due
		System.out.printf("\nSubtotal:\t$%.2f%n", total);
		System.out.printf("HST: \t\t$%.2f%n", hst);
		System.out.printf("Your total:\t$%.2f%n",finalTotal);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~\n      Thank You!");
	}
}