//Josh Gardner
//Commander Schenk
//AP CS50 4th Period
//3 March 2020
//Tasks 16 and 14

package gardner.two;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


//task 16
public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Would you like to figure out how an assessment will effect your grade"
				+ " or what you need to get on an assessment to achieve a desired grade?");
		String question = new String("'Desired grade' or 'What if'(how the assessment will effect your grade): ");
		System.out.println(question);
		//taking in user input
		BufferedReader first =  new BufferedReader(new InputStreamReader(System.in));
		//using toLowerCase method so that user's response is not case sensitive
		String firstq = first.readLine().toLowerCase();
		//using user input to decide what method to run
		//parent method implementing two other methods
		if(firstq.equals("desired grade")) {
			desiredGrades();
		} else if(firstq.equals("what if")) {
			whatIf();
		} else {
			System.out.println("Error");
			main(args);
		}
		System.out.println();
	}
	
	
	public static void desiredGrades() throws IOException {
		//String str = new String("Enter Formative and Summative averages (percent grade; ex: 92.54)");
		//System.out.println(str);
		//System.out.println("This is under the assumption that...");
		//System.out.println("Formative/quiz grades are weighted as .3, summative/test grades are weighted at .5,"
		//		+ " and the final is weighted at .2");
		//obtaining formative average from user
		System.out.print("Enter the number of weight types: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str2 = br.readLine();
		int f = Integer.parseInt(str2);
		double weightArr[];
		weightArr = new double[f];
		
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String str3;
		double weight;
		System.out.print("Leave Final grade for last...");
		for(int i = 0; i < f; i++) {
			System.out.print("Enter the weight of section " + i + ": ");
			str3 = br2.readLine();
			weight = Double.parseDouble(str3);
			weightArr[i] = weight;
		}
		
		BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
		String str4;
		double gradeVal;
		double gradeArr[];
		gradeArr = new double[f];
		for(int i = 0; i < weightArr.length - 1; i++) {
			System.out.print("Enter the grade of section " + i + " with weight " + weightArr[i] + ": ");
			str4= br3.readLine();
			gradeVal = Double.parseDouble(str4);
			gradeArr[i] = gradeVal;
		}
		
		double finalGrade = 0;
		for(int i = 0; i < gradeArr.length - 1; i++) {
			finalGrade += gradeArr[i] * weightArr[i];
		}
		
		System.out.print("Enter your desired grade: ");
		BufferedReader br5 = new BufferedReader(new InputStreamReader(System.in));
		String str5 = br2.readLine();
		double desiredGrade = Double.parseDouble(str5);
		
		double requiredGrade = ((desiredGrade - finalGrade)/weightArr[weightArr.length - 1]) + finalGrade;
		System.out.println("You need a " + requiredGrade);
	
		
		
		//obtaining summative average from user and calculating grade
		/*System.out.print("Enter your summative(test) average: ");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String str3 = br2.readLine();
		double s = Double.parseDouble(str3);
		double grade = (.5*s + .3*f)/.8;
		System.out.println("Your overall average is: " + grade);
		boolean correct = false;
		do {
			String question = new String("What type of assessment are you asking about? Quiz, Test, or Final");
			System.out.println(question);
			BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
			String questionResponse = brr.readLine().toLowerCase();
			//uses the input from user to choose between quiz, test, or final
		
			
			//task 14
			switch(questionResponse) {
				case "quiz":
					System.out.print("What is your desired grade: ");
					BufferedReader quiz = new BufferedReader(new InputStreamReader(System.in));
					String desiredQuiz = quiz.readLine();
					double g = Double.parseDouble(desiredQuiz);
					//finding the number of quizzes to know how much a new quiz will effect formative average
					System.out.print("Enter the current total number of formative points (number of quizzes taken * 100): ");
					BufferedReader numberOfQuiz = new BufferedReader(new InputStreamReader(System.in));
					String nOQ = numberOfQuiz.readLine();
					double qN = Double.parseDouble(nOQ);
					//calculating what the user would need to get on a quiz to achieve their desired grade
					double requiredQuizAverage = ((g*.8) - (.5*s))/.3;
					double requiredQuizGrade = ((requiredQuizAverage/100)*(qN + 100)) - ((f/100)*qN);
					//printing results to user
					if(requiredQuizGrade > 100) {
						System.out.println("You cannot achieve this grade with one quiz :(");
						System.out.println("You would need to get a " +requiredQuizGrade);
					} else if(requiredQuizGrade <= 100) {
						System.out.println("You will need to get a " + requiredQuizGrade + " on your quiz to get that grade");
						System.out.println("Your new quiz average would be a " + requiredQuizAverage);
					}
					correct = true;
					break;
				case "test":
					System.out.println("What is your desired grade: ");
					BufferedReader test = new BufferedReader(new InputStreamReader(System.in));
					String desiredTest = test.readLine();
					double gr = Double.parseDouble(desiredTest);
					System.out.println("Enter the current total number of summative points (number of tests taken * 100): ");
					BufferedReader numberOfTest = new BufferedReader(new InputStreamReader(System.in));
					String nOT = numberOfTest.readLine();
					double tN = Double.parseDouble(nOT);
					double requiredTestAverage = ((gr*.8) - (.3*f))/.5;
					double requiredTestGrade = ((requiredTestAverage/100)*(tN + 100)) - ((s/100)*tN);
					if(requiredTestGrade > 100) {
						System.out.println("You cannot achieve this grade with one test :(");
						System.out.println("You would need to get a " +requiredTestGrade);
					} else if(requiredTestGrade <= 100) {
						System.out.println("You will need to get a " + requiredTestGrade + " on your test to get that grade");
						System.out.println("Your new test average would be a " + requiredTestAverage);
					}
					correct = true;
					break;
				case "final":
					System.out.println("What is your desired grade: ");
					BufferedReader finalExam = new BufferedReader(new InputStreamReader(System.in));
					String desiredFinal = finalExam.readLine();
					double fi = Double.parseDouble(desiredFinal);
					double requiredFinalGrade = ((fi) - (.5*f) - (.3*s))/.2;
					if(requiredFinalGrade > 100) {
						System.out.println("You cannot achieve this grade with the final exam :(");
						System.out.println("You would need to get a " +requiredFinalGrade);
					} else if(requiredFinalGrade <= 100) {
						System.out.println("You will need to get a " +requiredFinalGrade +" on your final to" 
								+ " end with a " + fi);
					}
					correct = true;
					break;
			}
		}while (!correct);*/
	}
	//method that tells user how a certain quiz, test, or final grade will effect their class average
	public static void whatIf() throws IOException {	
		String str = new String("Enter Formative and Summative averages (percent grade; ex: 92.54)");
		System.out.println(str);
		System.out.println("This is under the assumption that...");
		System.out.println("Formative/quiz grades are weighted as .2, summative/test grades are weighted at .5,"
				+ " and the final is weighted at .2");
		System.out.print("Enter your formative(quiz) average: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str2 = br.readLine();
		double f = Double.parseDouble(str2);
		System.out.print("Enter your summative(test) average: ");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String str3 = br2.readLine();
		double s = Double.parseDouble(str3);
		double grade = (.5*s + .2*f)/.7;
		System.out.println("Your overall average is: " + grade);
		System.out.println("What are you interested in?");
		//takes in user input to decide which part of switch statement to execute
		boolean correct = false;
		do {
		System.out.println("Quiz, Test, or Final: ");
		BufferedReader qtf = new BufferedReader(new InputStreamReader(System.in));
		String assessment = qtf.readLine().toLowerCase();
		switch(assessment) {
		case "quiz":
			System.out.print("Enter the current total number of formative points (number of quizzes taken * 100): ");
			BufferedReader numberOfQuiz = new BufferedReader(new InputStreamReader(System.in));
			String nOQ = numberOfQuiz.readLine();
			double qN = Double.parseDouble(nOQ);
			//loop that continues going until user says no
			//this way the user can enter as many quiz grades as they would like
			String repeat;
			do {
			System.out.print("Enter quiz grade: ");
			BufferedReader tQGrade = new BufferedReader(new InputStreamReader(System.in));
			String qg = tQGrade.readLine();
			double qGrade = Double.parseDouble(qg);
			double quizAverage = f/100;
			double newQuizAverage = (((quizAverage * qN) + qGrade)/(qN + 100))*100;
			double newQuizGradeAverage = ((.5*s) + (.2*newQuizAverage))/.7;
			System.out.println("Getting a " + qGrade + " on the quiz will give you a " 
			+ newQuizGradeAverage + " in the class and a formative average of " + newQuizAverage);
			System.out.println("Would you like to enter another one?");
			System.out.println("Yes or No: ");
			BufferedReader keepGoingQ = new BufferedReader(new InputStreamReader(System.in));
			repeat = keepGoingQ.readLine().toLowerCase();
			} while (repeat.equals("yes"));
			correct = true;
			break;
		case "test":
			System.out.print("Enter the current total number of formative points (number of quizzes taken * 100): ");
			BufferedReader numberOfTest = new BufferedReader(new InputStreamReader(System.in));
			String nOT = numberOfTest.readLine();
			double tN = Double.parseDouble(nOT);
			do {
				System.out.print("Enter test grade: ");
				BufferedReader tTGrade = new BufferedReader(new InputStreamReader(System.in));
				String tg = tTGrade.readLine();
				double tGrade = Double.parseDouble(tg);
				double testAverage = s/100;
				double newTestAverage = (((testAverage * tN) + tGrade)/(tN + 100))*100;
				double newTestGradeAverage = ((.2*f) + (.5*newTestAverage))/.7;
				System.out.println("Getting a " + tGrade + " on the test will give you a " 
				+ newTestGradeAverage + " in the class and a summative average of " + newTestAverage);
				System.out.println("Would you like to enter another one?");
				System.out.println("Yes or No: ");
				BufferedReader keepGoingQ = new BufferedReader(new InputStreamReader(System.in));
				repeat = keepGoingQ.readLine().toLowerCase();
				} while (repeat.equals("yes"));
			correct = true;
			break;
		case "final":
			do {
				System.out.print("Enter final grade: ");
				BufferedReader tFGrade = new BufferedReader(new InputStreamReader(System.in));
				String fg = tFGrade.readLine();
				double fGrade = Double.parseDouble(fg);
				if(fGrade > s) {
					s = (fGrade + s)/2;
				}
				double newFGradeAverage = ((.5*s) + (.2*f) + (.3*fGrade));
				System.out.println("Getting a " + fGrade + " on the final will give you a " 
				+ newFGradeAverage + " in the class.");
				System.out.println("Would you like to enter another one?");
				System.out.println("Yes or No: ");
				BufferedReader keepGoingQ = new BufferedReader(new InputStreamReader(System.in));
				repeat = keepGoingQ.readLine().toLowerCase();
				} while (repeat.equals("yes"));
			correct = true;
			break;
		}
		}while (!correct);
	}
}