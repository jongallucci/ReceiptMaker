import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReceiptMaker{

	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		String itemBought = "";
		List<String> itemList = new ArrayList<String>();
		
		System.out.println("Enter items bought, write 'end' when done: ");
		while(!itemBought.equals("end")){
			itemBought = reader.nextLine();
			itemList.add(itemBought);
		}
		
		System.out.println(itemList);
		System.out.println("Done.");
	}
}

