import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	public static int[] opCountSearch = new int[500];
	
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
	
	public static void build(int n) {
		try {
			Scanner scan = new Scanner(new File("cleaned_data.csv"));
			scan.nextLine();
			int count = 0;
			while(count<n) {
				Scanner line = new Scanner(scan.nextLine()).useDelimiter(",");
				String date = line.next();
				double power = line.nextDouble();
				line.next();
				double voltage = line.nextDouble();
				Item temp = new Item(date,power,voltage);
				x.insert(temp);
				count++;
				
			}
	
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void subsetSearch(int n) {
		try {
			Scanner sc2 = new Scanner(new File("FileWithSearchKeys.txt"));
			int count = 0;
			while(count<n) {
				x.opCount=0;
				printDateTime(sc2.nextLine());
				opCountSearch[count] = x.opCount;
				count++;
			}
		
		
		
		
		
		
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static int getWorst() {
		int max = opCountSearch[0];
		for(int i = 0;i<opCountSearch.length;i++) {
			if(opCountSearch[i]>max) {
				max = opCountSearch[i];
			}
		}
		return max;
	}
	
	public static int getBest() {
		int min = opCountSearch[0];
		for(int i = 0;i<opCountSearch.length;i++) {
			if(opCountSearch[i]<min) {
				min = opCountSearch[i];
			}
		}
		return min;
	}
	
	public static double getAve() {
		double sum = 0;
		for(int i = 0;i<opCountSearch.length;i++) {
			sum+=opCountSearch[i];
		}
	
	return sum/opCountSearch.length;
	}
	
	public static void writer(int n) {
		
		try {
			FileWriter writer = new FileWriter("outputBST.csv", true);
			BufferedWriter bw = new BufferedWriter(writer);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(n+","+getBest()+","+getWorst()+","+getAve());
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		 
		build(500);
		
		
		if(args.length==0) {
			printAllDateTimes();
		}
		else if(args[0].equalsIgnoreCase("FileWithSearchKeys.txt")) {
			try {
				Scanner sc = new Scanner(new File("FileWithSearchKeys.txt"));
				int i = 0;
				while(i<500) {
					x = new BinarySearchTree<>();
					int n = i+1;
					opCountSearch = new int[n];
					build(n);
					subsetSearch(n);
					writer(n);
					
					System.out.println("..."+n);
					i++;
					
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
