import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class main {
	public static String webName = "C:\\Users\\Khant\\eclipse-workspace\\Schedule\\bin\\Test.txt";
	public static String prizePool = "C:\\Users\\Khant\\eclipse-workspace\\Schedule\\bin\\prizePool.txt";
	
	public static void write(String Homework, String Test_Project, String Chores, ArrayList<String> input1, ArrayList<String> input2, ArrayList<String> input3, String points) {
		
		Scanner scan = new Scanner(System.in);
		
		try {
		      	FileWriter myWriter = new FileWriter(webName);
		      	myWriter.write(points);
		      	myWriter.write("\n");
		      	myWriter.write(Homework);
		      	myWriter.write("\n");
		      	myWriter.write(Test_Project);
		      	myWriter.write("\n");
		      	myWriter.write(Chores);
		      	myWriter.write("\n");
		      	
		      	int test = 0;
		      	for (int k = 0; k < input1.size(); k++){
		      		test = k;
		      		myWriter.write(input1.get(test));
		      		myWriter.write("\n");
		      		myWriter.write(input2.get(test));
			      	myWriter.write("\n");
			      	myWriter.write(input3.get(test));
			      	myWriter.write("\n");
		      	}
		      	Scanner reader = new Scanner(System.in);
		      	System.out.println("What is the name of the assignment?");
				String newInputName = scan.nextLine();
				System.out.println("When is the assignment due? [MM/DD/YYYY]");
				String newInputDate = scan.nextLine();
				System.out.println("Is it [1]Homework, [2]Test/Project, or [3]Chores? [input the corresponding number.]");
				int n = reader.nextInt();
		      	
				System.out.println(newInputName + " " + newInputDate);
				
		      	myWriter.write(newInputName);
		      	myWriter.write("\n");
		      	myWriter.write(newInputDate);
		      	myWriter.write("\n");
		      	if (n==1) {
		      		myWriter.write("Homework");
		      	}
		      	if (n==2) {
		      		myWriter.write("Test/Project");
		      	}
		      	if (n==3) {
		      		myWriter.write("Chores");
		      	}
		      
		      myWriter.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public static void view(ArrayList<String> input1, ArrayList<String> input2, ArrayList<String> input3) {
		
		System.out.println("Assignment          Date");
		for (int p = 0 ; p<input1.size(); p++) {
			System.out.print(input2.get(p));
			String temp = input2.get(p);
			for (int s = temp.length(); s < 20; s++) {
				System.out.print(" ");
			}
			System.out.println(input1.get(p));
			temp=input1.get(p);
			for (int s = temp.length(); s < 20; s++) {
				System.out.print(" ");
			}
			System.out.println(input3.get(p));
		}
		
		return;
	}
	
	public static void complete (String Homework, String Test_Project, String Chores, ArrayList<String> input1, ArrayList<String> input2, ArrayList<String> input3, String points) {
		for (int p = 0 ; p<input1.size(); p++) {
			System.out.print("[" + (p+1) + "]" + input2.get(p));
			String temp = input2.get(p);
			for (int s = temp.length(); s < 20; s++) {
				System.out.print(" ");
			}
			System.out.println(input1.get(p));
			temp=input1.get(p);
			for (int s = temp.length(); s < 20; s++) {
				System.out.print(" ");
			}
			System.out.println(input3.get(p));
		}
		
		System.out.println("Which assignment did you complete? [insert corresponding number]");
		
		Scanner reader = new Scanner(System.in);
		int completedAssignment = reader.nextInt();
  		System.out.println("Check");
  		System.out.println(completedAssignment);
		deleteAssignment(Homework, Test_Project, Chores, input1, input2, input3, completedAssignment, points);
		return;
	}
	
	public static void deleteAssignment (String Homework, String Test_Project, String Chores,  ArrayList<String> input1, ArrayList<String> input2, ArrayList<String> input3, int delete, String points){
		try {
	      	FileWriter myWriter = new FileWriter(webName);
	      	myWriter.write(points);
	      	myWriter.write("\n");
	      	myWriter.write(Homework);
	      	myWriter.write("\n");
	      	myWriter.write(Test_Project);
	      	myWriter.write("\n");
	      	myWriter.write(Chores);
	      	myWriter.write("\n");
	      	
	      	System.out.println(delete);
	      	
	      	int test = 0;
	      	for (int k = 0; k < delete-1; k++){
	      		test = k;
	      		myWriter.write(input2.get(test));
	      		myWriter.write("\n");
	      		myWriter.write(input1.get(test));
	      		myWriter.write("\n");
	      		myWriter.write(input3.get(test));
	      		myWriter.write("\n");
	      	}
	      	for (int k = delete; k < input1.size(); k++){
	      		test = k;
	      		myWriter.write(input2.get(test));
	      		myWriter.write("\n");
	      		myWriter.write(input1.get(test));
	      		myWriter.write("\n");
	      		myWriter.write(input3.get(test));
	      		myWriter.write("\n");
	      	}
	      
	      myWriter.close();
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		return;
	}
	
	public static void prizePool() {
		
		ArrayList<String> prize = new ArrayList<String>();
		ArrayList<String> cost = new ArrayList<String>();
		
		try {
			File myObj = new File(prizePool);
			System.out.println(myObj);
	        Scanner myReader = new Scanner(myObj);
	        
	        
			System.out.println("These are your possible prizes");
			
	        while (myReader.hasNextLine()) {
		        prize.add(myReader.nextLine());
		        cost.add(myReader.nextLine());
	        }
	        myReader.close();
	    }
		catch (FileNotFoundException e) {
	    	System.out.println("An error occurred.");
	    	e.printStackTrace();
	    }
		
		for (int k = 0; k < prize.size(); k++) {
			System.out.print ("[" + (k+1) + "] " + prize.get(k));
			String tempo = prize.get(k);
			for (int x=tempo.length(); x < 20; x++) {
				System.out.print(" ");
			}
			System.out.println (cost.get(k));
		}
		System.out.println("What would you like? [choose numbered option]");
		Scanner reader = new Scanner(System.in);
		int ans = reader.nextInt();
		int subtract=Integer.parseInt(cost.get(ans-1));  
		System.out.println(subtract);
	}

	public static void main(String[] args) {
		//loading files
		boolean x=true;
		while (x) {
		
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> type = new ArrayList<String>();
		String points = null;
    	String Homework=null;
    	String Test_Project=null;
    	String Chores=null;
		
		try {
			File myObj = new File(webName);
			System.out.println(myObj);
	        Scanner myReader = new Scanner(myObj);
	        
	        points = myReader.nextLine();  
	        Homework = myReader.nextLine();
	        Test_Project = myReader.nextLine();
	        Chores = myReader.nextLine();
	        
	        while (myReader.hasNextLine()) {
	        	name.add(myReader.nextLine());
		        date.add(myReader.nextLine());
		        type.add(myReader.nextLine());
	        }
	        myReader.close();
	    }
		catch (FileNotFoundException e) {
	    	System.out.println("An error occurred.");
	    	e.printStackTrace();
	    }
		//Code starts here
		
		Scanner reader = new Scanner(System.in);
		System.out.println("What would you like to do?");
		System.out.println("[1] Add Assignment  [2] View Assignments  [3] Complete Assignemnt  [4] Use points  [5] Exit");
		int n = reader.nextInt();
		
		//Option 1 Add New Assignment
		if (n == 1) {
			write(Homework, Test_Project, Chores, date, name, type, points);
			System.out.println("Done");
		}
		else if (n==2) {
			view(date, name, type);
		}
		else if (n==3) {
			complete(Homework, Test_Project, Chores, date, name, type, points);
		}
		else if (n==4) {
			prizePool();
		}
		else if (n==5) {
			x=false;
		}
		else {
			
					
		}
	}
}
}
	