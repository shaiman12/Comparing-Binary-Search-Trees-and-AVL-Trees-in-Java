import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PowerAVLApp {

	public static AVLTree<Item> x = new AVLTree<Item>();
	public static int[] opCountSearch = new int[500];
	public static int[] opCountInsert = new int[500];
	
	/**
	 * The printAllDateTimes method returns a string output of all the date/times stored in the AVL tree of ‘Item’ objects using the PrintTree method defined in the AVL tree class.
	 */
	public static void printAllDateTimes() {
		x.inOrder();
		
	}
	public static void printDateTime(String dateTime) {

		System.out.println(x.find(dateTime));
		
	}
	
	
	public static void build(int n) {
		try {
			Scanner scan = new Scanner(new File("cleaned_data.csv"));
			scan.nextLine();
			int count = 0;
			 opCountInsert = new int[n];
			while(count<n) {
				
				Scanner line = new Scanner(scan.nextLine()).useDelimiter(",");
				String date = line.next();
				double power = line.nextDouble();
				line.next();
				double voltage = line.nextDouble();
				Item temp = new Item(date,power,voltage);
				x.insert(temp);
				opCountInsert[count] = x.opCountInsert; 
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
	
	
	public static int getWorst(int q ) {
		if(q==0) {
		int max = opCountSearch[0];
		for(int i = 0;i<opCountSearch.length;i++) {
			if(opCountSearch[i]>max) {
				max = opCountSearch[i];
			}
		}
		return max;}
		else {
			int max = opCountInsert[0];
			for(int i = 0;i<opCountInsert.length;i++) {
				if(opCountInsert[i]>max) {
					max = opCountInsert[i];
				}
			}
			return max;
			
		}
	}
	
	public static int getBest(int q) {
		if(q==0) {
		int min = opCountSearch[0];
		for(int i = 0;i<opCountSearch.length;i++) {
			if(opCountSearch[i]<min) {
				min = opCountSearch[i];
			}
		}
		return min;}
		else {
			int min = opCountInsert[0];
		for(int i = 0;i<opCountInsert.length;i++) {
			if(opCountInsert[i]<min) {
				min = opCountInsert[i];
			}
		}
		return min;
			
		}
	}
	
	public static double getAve(int q) {
		double sum = 0;
		if(q==0) {
		for(int i = 0;i<opCountSearch.length;i++) {
			sum+=opCountSearch[i];
		}
	
	return sum/opCountSearch.length;}
		else {
			for(int i = 0;i<opCountInsert.length;i++) {
			sum+=opCountInsert[i];
		}
	
	return sum/opCountInsert.length;
			
		}
		
	}
	
	public static void writer(int n) {
		
		try {
			FileWriter writer = new FileWriter("outputAVL.csv", true);
			BufferedWriter bw = new BufferedWriter(writer);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(n+","+getBest(0)+","+getWorst(0)+","+getAve(0));
			pw.flush();
			pw.close();
			writer = new FileWriter("outputAVLInsert.csv", true);
			bw = new BufferedWriter(writer);
			pw = new PrintWriter(bw);
			pw.println(n+","+getBest(1)+","+getWorst(1)+","+getAve(1));
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
					x = new AVLTree<Item>();
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
		
		
		

}}
