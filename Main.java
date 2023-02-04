//Josh Gardner
//Commander Schenk
//APCS50 4th Period
//24 April 2020
//Master Project

package gardner.two;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
	
	public static void main(String[] args) throws IOException {
		//Printing out all of the options that the user can choose from
		System.out.println("Type 'desired gpa' if you would like to see what you need to get in your remaining classes to get a certain gpa");
		System.out.println("Type 'what if' if you would like to see how certain averages will effect your gpa");
		System.out.println("Type 'this year' if you would like to enter your current grades to see how it will effect your gpa");
		System.out.println("Type 'conversion' if you would like to know the conversion of your GPA on a 4.0/numeric scale");
		String question = new String("What would you like to know?: ");
		System.out.println(question);
		//taking in user input
		BufferedReader first =  new BufferedReader(new InputStreamReader(System.in));
		//using toLowerCase method so that user's response is not case sensitive
		String firstq = first.readLine().toLowerCase();
		//using user input to decide what method to run
		//parent method implementing other methods
		if(firstq.equals("desired gpa")) {
			desiredGPA();
		} else if(firstq.equals("what if")) {
			whatIf();
		} else if(firstq.equals("this year")) {
			thisYear();
		} else if(firstq.equals("conversion")){
			conversion();
		}	else {
			System.out.println("Error: Incorrect value entered");
			main(args);
		}
	}
	
	public static void desiredGPA() throws IOException {
		//Prompting user for the number of classes/grades
		System.out.println("Enter the number of classes you have taken ");
		System.out.println("The number of grades you have on your transcript: ");
		//taking in the user input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		double nOC = Double.parseDouble(str);
		
		//gathering all of the variables needed for the caculation
		System.out.println("Enter your cumulative GPA: ");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br1.readLine();
		double GPA = Double.parseDouble(str1);
		
		double totalEarnedPoints = nOC * GPA;
		
		System.out.println("Enter the number of AP/Honors courses: ");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String str2 = br2.readLine();
		double numberOfAdvanced = Double.parseDouble(str2);
		
		double unweightedGPA = (totalEarnedPoints - (numberOfAdvanced * 7))/nOC;
		
		System.out.println("Your unweighted GPA is a " + unweightedGPA);
		
		System.out.println("Enter your desired cumulative GPA: ");
		BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
		String str3 = br3.readLine();
		double desired = Double.parseDouble(str3);
		
		System.out.println("How many classes do you have to achieve this: ");
		BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
		String str4 = br4.readLine();
		double remainingClasses = Double.parseDouble(str4);
		
		double var = nOC + remainingClasses;
		//calculating what the user would need to average to achieve their desired gpa
		double requiredAverage = ((desired * var) - (nOC * GPA))/remainingClasses;
		System.out.println("You would need to average a " + requiredAverage + " in your remaining classes"); 
	}

	public static void whatIf() throws IOException {
		
		//gathering the required variables to perform the calculations
		System.out.println("Enter your cumulative GPA: "); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		double gpa = Double.parseDouble(str);
		
		System.out.println("Enter the number of courses that you have taken: ");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br1.readLine();
		double nOC = Double.parseDouble(str1);
	
		//do while that allows the user to test as many times as they want without having to re-run the program
		String repeat;
		do {
		System.out.println("Enter the number of courses remaining: ");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String str2 = br2.readLine();
		double nOCL = Double.parseDouble(str2);
		
		System.out.println("Enter the average grade in those courses: ");
		BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
		String str3 = br3.readLine();
		double aGPA = Double.parseDouble(str3);
		
		//using the input to calculate what the new gpa would be
		double newGPA = ((gpa*nOC) + (aGPA * nOCL))/(nOC + nOCL);
		
		System.out.println("This would result in your new GPA being a " + newGPA);
		
		System.out.println("Would you like to enter another one?");
		System.out.println("Yes or No: ");
		BufferedReader keepGoingQ = new BufferedReader(new InputStreamReader(System.in));
		//this is what allows the user to re-execute the 'what if' method without having to re run the program
		repeat = keepGoingQ.readLine().toLowerCase();
		} while(repeat.equals("yes"));
	}
	
	public static void thisYear() throws IOException {
		
		//user enters their current grades for the term
		System.out.println("Enter grade 1: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		double gr1 = Double.parseDouble(str);
		
		System.out.println("Enter grade 2: ");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br1.readLine();
		double gr2 = Double.parseDouble(str1);
		
		System.out.println("Enter grade 3: ");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String str2 = br2.readLine();
		double gr3 = Double.parseDouble(str2);
		
		System.out.println("Enter grade 4: ");
		BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
		String str3 = br3.readLine();
		double gr4 = Double.parseDouble(str3);
		
		System.out.println("Enter grade 5: ");
		BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
		String str4 = br4.readLine();
		double gr5 = Double.parseDouble(str4);
		
		System.out.println("Enter grade 6: ");
		BufferedReader br5 = new BufferedReader(new InputStreamReader(System.in));
		String str5 = br5.readLine();
		double gr6 = Double.parseDouble(str5);
		
		//averaging their grades to find their average grade
		double thisYearGPA = (gr1 + gr2 + gr3 + gr4 + gr5 + gr6)/6;
		System.out.println("Your current GPA for this term is a " + thisYearGPA);
		
		System.out.println("Enter your current GPA: ");
		BufferedReader br6 = new BufferedReader(new InputStreamReader(System.in));
		String str6 = br6.readLine();
		double currentGPA = Double.parseDouble(str6);
		
		System.out.println("Enter your number of classes taken: ");
		BufferedReader br7 = new BufferedReader(new InputStreamReader(System.in));
		String str7 = br7.readLine();
		double nOC = Double.parseDouble(str7);
		
		//using their current average, number of courses, and gpa to calculate their new gpa 
		double newGPA = ((currentGPA * nOC) + (thisYearGPA * 6))/(nOC + 6);
		
		System.out.println("If the term ended with these current grades,");
		System.out.println("Your new GPA would be a " + newGPA);
	}
	
	public static void conversion() throws IOException {
		
		System.out.println("Enter 'numeric' if you would like to see your numeric GPA using your 4.0 ");
		System.out.println("Enter 'four' if you would like to see your 4.0 GPA using your numeric");
		
		System.out.println("Numeric or 4.0: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String decision = br.readLine().toLowerCase();
	
		//switch statement that uses the input of the user to decide which branch/case to execute
		switch(decision) {
		case "numeric":
			
			//takes in the users 4.0 gpa to calculate what their numeric gpa would be
			System.out.println("Enter your current GPA on a 4.0 scale: ");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			String str1 = br1.readLine();
			double currentGPA = Double.parseDouble(str1);
			
			double numeric = (currentGPA + 1) * 20;
			
			System.out.println("Your numeric GPA would be a " + numeric);
			break;
		case "four":
			
			//takes in the users numeric gpa to calculate what their 4.0 gpa would be
			System.out.println("Enter your current numeric GPA: ");
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			String str2 = br2.readLine();
			double numericGPA = Double.parseDouble(str2);
			
			double four = (numericGPA/20) - 1;
			
			System.out.println("Your GPA on a 4.0 scale would be a " + four);
			break;
		}
		
	}
}