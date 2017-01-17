import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReceiptMaker{

	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);	//setup to read user inputs
		String itemBought = "";
		List<String> itemList = new ArrayList<String>();	//list to hold all items bought by user
		
		System.out.println("Enter items bought, write 'end' when done: ");
		while(!itemBought.equals("end")){
			itemBought = reader.nextLine();		//reads user inputs and stores them
			itemList.add(itemBought);			//adds items to list
		}
		itemList.remove(itemList.size()-1);		//removes 'end' from list
		System.out.println(itemList);
		System.out.println("Done.");
	}
}