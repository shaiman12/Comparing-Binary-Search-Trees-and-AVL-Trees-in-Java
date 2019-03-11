import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PowerAVLApp {

	public static AVLTree<Item> x = new AVLTree<Item>();
	public static int[] opCountSearch = new int[500];
	
	/**
	 * The printAllDateTimes method returns a string output of all the date/times stored in the AVL tree of ‘Item’ objects using the PrintTree method defined in the AVL tree class.
	 */
	public static void printAllDateTimes() {
		x.inOrder();
		
	}
	public static void printDateTime(String dateTime) {

		System.out.println(x.find(dateTime));
	}
	
	
	

	public static void main(String[] args) {
		 
		try {
			Scanner scan = new Scanner(new File("cleaned_data.csv"));
			scan.nextLine();
			int count = 0;
			while(scan.hasNextLine()) {
				Scanner line = new Scanner(scan.nextLine()).useDelimiter(",");
				String date = line.next();
				double power = line.nextDouble();
				line.next();
				double voltage = line.nextDouble();
				Item temp = new Item(date,power,voltage);
				x.insert(temp);
				
				
			}
	
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		if(args.length==0) {
			printAllDateTimes();
		}
		else if(args[0].equalsIgnoreCase("FileWithSearchKeys.txt")) {
			try {
				Scanner sc = new Scanner(new File("FileWithSearchKeys.txt"));
				int i = 0;
				while(sc.hasNextLine()) {
					x.opCount=0;
					printDateTime(sc.nextLine());
					
					
				}
			
			
			sc.close();
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		else if(args[0].length()!=19) {
			System.out.println("Invalid input");
		}
		else {
			printDateTime(args[0]);
		}
		
		
		

}}
