import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 *
 * This is an application that reads in a CSV file called ‘cleaned_data.csv’ and uses a set of scanners to carefully extract the required information from the file to store into ‘Item’ objects. 
 * So every time the scanner reads a new line of the CSV file, a new ‘Item’ object is created and inserted into the binary search tree that is stored as an instance variable.
 * Just before the program terminates the opCount instance variable is stored in a text file called BSTPerformance.txt.
 * @author ShaiAarons
 */


public class PowerBSTApp {

	private static BinarySearchTree<Item> x = new BinarySearchTree<>();
	
	
	/**
	 * The printAllDateTimes method returns a string output of all the date/times stored in the binary search tree of ‘Item’ objects using the inOrder traversal defined in the BinarySearchTree class.
	 */
	public static void printAllDateTimes() {
		x.inOrder();
		
	}
	
	
	/**
	 * The printDateTime method receives a String argument in the form of a specific date/time that the user is looking and returns a string with the information relating to that specific date/time using the toString method defined in the Item class by using the find method in the BinarySearchTree class.
	 * @param dateTime used as the String passed to search for in the binary serach tree.
	 */
	public static void printDateTime(String dateTime) {

		if (x.find(dateTime)==null) {
			System.out.println("Date/time not found");
		}else {
			System.out.println(x.find(dateTime));
		}
	}
	
	

	public static void main(String[] args) {
		 
		try {
			Scanner scan = new Scanner(new File("cleaned_data.csv"));
			String ignore = scan.nextLine();
			int count = 0;
			while(scan.hasNextLine()) {
				Scanner line = new Scanner(scan.nextLine()).useDelimiter(",");
				String date = line.next();
				double power = line.nextDouble();
				ignore = line.next();
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
		
		
		
		
		

	}//end of main

}//end of class
