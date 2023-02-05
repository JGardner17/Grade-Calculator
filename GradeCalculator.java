package CUHackit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;

import CUHackit.GpaCalc;
import CUHackit.ClassCalc;

public class GradeCalculator {
    public static void main(String args[]) throws IOException {
        System.out.println("\n\n\t\t\tWelcome!!!\n");
        System.out.println("This program allows you to see how certain assessments/averages will effect your GPA,");
        System.out.println("as well as perform a conversion of your GPA on a numeric/4.0 scale.");

        System.out.println("\n\nYou can also see how certain assessments will effect your class average,");
        System.out.println("or what you need to get on an upcoming assignment in order to achieve a desired grade.\n");

        int quit = 0;
        do {
            System.out.println("Would you like to see GPA information (Enter '1') or Class Average information (Enter '2').");
            BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
            String userIn = bR.readLine();
            int userSelection = Integer.parseInt(userIn);

            switch (userSelection) {
                case 1:
                    gpa();
                    System.out.println("\n\n\nWould you like to start again?\n\n\tYes (Enter 1) or No (Enter 0)");
                    userIn = bR.readLine();
                    quit = Integer.parseInt(userIn);
                    break;
                case 2:
                    classAvg();
                    System.out.println("\n\n\nWould you like to start again?\n\n\tYes (Enter 1) or No (Enter 0)");
                    userIn = bR.readLine();
                    quit = Integer.parseInt(userIn);
                    break;
                default:
                    System.out.println("Please enter either '1' or '2'!");
                    quit = 1;
            }
        } while(quit != 0);
        System.out.println("\n\n\t\t\t\tThank you for using!!");
    }

    public static void gpa() throws IOException {
        boolean again = false;
        do {
            System.out.println("There are multiple options regarding GPA information");
            System.out.println("\nOption '1' Desired GPA: Shows you what you need to get in your remaining" +
                    "classes in order to achieve a desired GPA.");
            System.out.println("Option '2' What If: Shows you how certain averages will effect your GPA.");
            System.out.println("Option '3' This Year: Shows you how your current class averages will effect your GPA.");
            System.out.println("Option '4' Conversion: Allows you to convert your GPA from numeric to 4.0 scale");
            System.out.println("Enter your desired option number: ");


            BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
            String userIn = bR.readLine();
            int userSelection = Integer.parseInt(userIn);

            switch (userSelection) {
                case 1:
                    desiredGPA();
                    break;
                case 2:
                    whatIfGpa();
                    break;
                case 3:
                    thisYear();
                    break;
                case 4:
                    conversion();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\tPlease enter a valid input!!");
                    again = true;
            }
        } while(again);
    }

    public static void classAvg() throws IOException {
        boolean again = false;
        do {
            System.out.println("There are multiple options regarding class average information");
            System.out.println("Option '1' What If: Shows you how assessment grades will effect your class average.");
            System.out.println("Option '2' Desired Grade: Shows you what you need on your upcoming assignments to get "
                            + "a certain grade.");
            System.out.println("Option '3' Aced-Out: Tells you what grade you would have if you aced your remaining assignments");
            System.out.println("Enter your desired option number: ");


            BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
            String userIn = bR.readLine();
            int userSelection = Integer.parseInt(userIn);

            switch (userSelection) {
                case 1:
                    whatIfClassAvg();
                    break;
                case 2:
                    desiredClassAvg();
                    break;
                case 3:
                    aceOut();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\tPlease enter a valid input!!");
                    again = true;
            }
        } while(again);
    }

    public static void desiredGPA() throws IOException {
        //Prompting user for the number of classes/grades
        System.out.println("Enter the number of credit hours you have taken.");
        //taking in the user input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userIn = br.readLine();
        double creditHoursTaken = Double.parseDouble(userIn);


        System.out.println("Enter your current GPA (out of 4.0): ");
        br = new BufferedReader(new InputStreamReader(System.in));
        userIn = br.readLine();
        double GPA = Double.parseDouble(userIn);

        System.out.println("Enter your desired GPA (out of a 4.0): ");
        br = new BufferedReader(new InputStreamReader(System.in));
        userIn = br.readLine();
        double desiredGpa = Double.parseDouble(userIn);
        if(desiredGpa > 1.5 && desiredGpa < 2.5) {
            System.out.println("Cs get degrees baby");
        }

        System.out.println("How many credit hours do you have remaining?: ");
        br = new BufferedReader(new InputStreamReader(System.in));
        userIn = br.readLine();
        double remainingCreditHours = Double.parseDouble(userIn);

        double totalHours = creditHoursTaken + remainingCreditHours;
        //calculating what the user would need to average to achieve their desired gpa
        double requiredAverage = ((desiredGpa * totalHours) - (creditHoursTaken * GPA))/remainingCreditHours;
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("You would need to average a " + df.format(requiredAverage) + " GPA in your remaining courses");

        if(requiredAverage > 4.0) {
            System.out.println("Unfortunately, this is not possible :/");
        } else if(requiredAverage == 4.0) {
            System.out.println("You need to finish out with straight As, but at least you have a chance.");
        } else if(requiredAverage > 3.5) {
            System.out.println("You need to average a mix of As and Bs, with an emphasis on the As.");
        } else if(requiredAverage > 3.0) {
            System.out.println("You need to average a mix of As and Bs, but only need a majority of Bs.");
        } else if(requiredAverage == 3.0) {
            System.out.println("You need to average straight Bs.");
        } else if(requiredAverage > 2.0) {
            System.out.println("You need to average a mix of Bs and Cs");
        } else if(requiredAverage > 1.0) {
            System.out.println("You only need to average a combination of Cs and Ds");
        } else {
            System.out.println("You can pretty much fail out and still get that GPA, good job");
        }
    }

    public static void whatIfGpa() throws IOException {
        //gathering the required variables to perform the calculations
        System.out.println("Enter your GPA (on 4.0 scale): ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        double gpa = Double.parseDouble(str);

        System.out.println("Enter the number of credit hours that you have taken: ");
        br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        double creditsTaken = Double.parseDouble(str);

        System.out.println("Enter the number of credit hours remaining: ");
        br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        double creditsRemaining = Double.parseDouble(str);

        //do while that allows the user to test as many times as they want without having to re-run the program
        int repeat;
        do {
            System.out.println("Enter the average grade in the remaining " + creditsRemaining +
                    " credit hours (on 4.0 scale): ");
            System.out.println("A = 4, B = 3, C = 2, D = 1, F = 0");
            br = new BufferedReader(new InputStreamReader(System.in));
            str = br.readLine();
            double avgGPA = Double.parseDouble(str);

            //using the input to calculate what the new gpa would be
            double newGPA = ((gpa*creditsTaken) + (avgGPA * creditsRemaining))/(creditsTaken + creditsRemaining);

            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println("This would result in your new GPA being a " + df.format(newGPA));

            System.out.println("Would you like to enter another one?");
            System.out.println("Yes ('1') or No('0'): ");
            BufferedReader keepGoingQ = new BufferedReader(new InputStreamReader(System.in));
            //this is what allows the user to re-execute the 'what if' method without having to re run the program
            String quit = keepGoingQ.readLine();
            repeat = Integer.parseInt(quit);
        } while(repeat != 0);
    }

    public static void thisYear() throws IOException {
        System.out.println("Enter the number of in-progress credit hours you currently have: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int currHours = Integer.parseInt(str);

        System.out.println("Enter the number of in-progress courses: ");
        double[] creditHoursArr = getWeights();
        double[] gradesArr = getGrades(creditHoursArr);
        double semesterGpa = getGpaFromNumeric(gradesArr, creditHoursArr, currHours);

        System.out.println("Enter your current GPA: ");
        str = br.readLine();
        double currGpa = Double.parseDouble(str);

        System.out.println("Enter your total completed hours: ");
        str = br.readLine();
        double prevHours = Double.parseDouble(str);

        double newGpa = ((currGpa * prevHours) + (semesterGpa * currHours))/(prevHours + currHours);
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Your new overall GPA would be a " + df.format(newGpa));
    }

    public static void conversion() throws IOException {
        System.out.println("Enter the total number of credit hours you have completed: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int creditHours = Integer.parseInt(str);

        System.out.println("Enter the number of completed courses: ");
        double[] creditHoursArr = getWeights();
        double[] gradesArr = getGrades(creditHoursArr);
        double currentGpa = getGpaFromNumeric(gradesArr, creditHoursArr, creditHours);

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Your current GPA is a " + df.format(currentGpa));
    }

    public static double[] getWeights() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int classNum = Integer.parseInt(str);

        //declaring array with length = numWeights
        double[] creditHoursArr = new double[classNum];

        //declaring variables needed in loop
        int weight = 0;
        double sum = 0;
        //for loop that starts at 0 (i = 0), runs until i reaches the end of the array (i < numWeights)
        //and increments by 1 (i++)
        for (int i = 0; i < classNum; i++) {
            //getting the weight values                    printing out weight index when asking (i + 1)
            System.out.println("Enter the credit hour value (eg. 4) for course weight " + (i + 1) + ": ");
            str = br.readLine();
            weight = Integer.parseInt(str);
            //validating user input
            if (weight > 6 || weight < 0) {
                //making sure user did not enter weights that are greater than 1 or less than 0
                System.out.println("Please enter a valid credit hour less than 7 and greater than 0.");
                //going back one iteration so that user does not lose progress and have to restart
                i--;
            } else {
                //if valid weight is entered, add it to array at index i
                creditHoursArr[i] = weight;
            }
        }
        return creditHoursArr;
    }

    public static double[] getNumericWeights() throws IOException {
        System.out.println("Enter the number of grade weights: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int classNum = Integer.parseInt(str);

        //declaring array with length = numWeights
        double[] weightsArr = new double[classNum];

        //declaring variables needed in loop
        double weight = 0;
        double sum = 0;
        //for loop that starts at 0 (i = 0), runs until i reaches the end of the array (i < numWeights)
        //and increments by 1 (i++)
        for (int i = 0; i < classNum; i++) {
            //getting the weight values                    printing out weight index when asking (i + 1)
            System.out.println("Enter the weight value (eg. .2 for 20%) for course weight " + (i + 1) + ": ");
            str = br.readLine();
            weight = Double.parseDouble(str);
            //validating user input
            if (weight > 100 || weight < 0) {
                //making sure user did not enter weights that are greater than 1 or less than 0
                System.out.println("Please enter a valid grade that is between 100 and 0.");
                //going back one iteration so that user does not lose progress and have to restart
                i--;
            } else {
                //if valid weight is entered, add it to array at index i
                weightsArr[i] = weight;
            }
            //validating more input
            //this is checking if it is the last iteration
            //(we know the last iteration will be when i = numWeights bc that is
            //the last index
            if (i == classNum - 1) {
                //summing up values of weights entered
                //resetting the value of sum for each time this process happens
                sum = 0;
                for (int j = 0; j < classNum; j++) {
                    sum += weightsArr[j];
                }
                //if the sum of the entered weights does not = 1, ask user to enter again
                //restart iterations (i = 0), takes user back to beginning of for loop
                if (sum != 1) {
                    System.out.println("Please enter weights that sum to 1.");
                    i = -1;
                }
            }
        }
        return weightsArr;
    }

    public static double[] getGrades(double[] weightsArr) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //declaring variable
        double gradeAvg = 0;
        //declaring new array of length = number of weights in weightsArr
        double[] gradesArr = new double[weightsArr.length];
        //for loop starting at 0 (i=0), iterates through to end of array (weightsArr.length)
        //and increments by 1 (i++)
        for(int i = 0; i < weightsArr.length; i++) {
            //getting grade % from user
            System.out.println("Enter your grade average (eg. 92.5) for weight " + (i+1) + " of " + weightsArr[i] + ": ");
            String str = br.readLine();
            gradeAvg = Integer.parseInt(str);
            //validating input and making sure the value is between 0 and 100
            if(gradeAvg > 100 || gradeAvg < 0) {
                System.out.println("Please enter a value between 0 and 100");
                //going back 1 iteration if this input is not valid
                i--;
            } else {
                //if input is valid, add the average to the current index of the grades array
                gradesArr[i] = gradeAvg;
            }
        }
        //returning the gradesArr full of grade %s
        return gradesArr;
    }

    public static double getGpaFromNumeric(double[] gradesArr, double[] weightsArr, int creditHours) {
        double[] semesterGp = new double[weightsArr.length];
        for(int i = 0; i < weightsArr.length; i++) {
            if(gradesArr[i] >= 90) {
                semesterGp[i] = 4;
            } else if(gradesArr[i] >= 80) {
                semesterGp[i] = 3;
            } else if(gradesArr[i] >= 70) {
                semesterGp[i] = 2;
            } else if(gradesArr[i] >= 60) {
                semesterGp[i] = 1;
            } else {
                semesterGp[i] = 0;
            }
        }
        double gradePointSum = 0;
        for(int i = 0; i < weightsArr.length; i++) {
            gradePointSum += semesterGp[i]*weightsArr[i];
        }
        double semesterGpa = gradePointSum/creditHours;
        return semesterGpa;
    }

    public static void whatIfClassAvg() throws IOException {
        double[] weightsArr = getNumericWeights();
        double[] gradesArr = getGrades(weightsArr);

        System.out.println("\n\n\nWhich assignment type would you like to test?");
        for(int i = 0; i < weightsArr.length; i++) {
            System.out.println("Option " + i + ": weight of " + weightsArr[i]);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int userSelection = Integer.parseInt(str);

        double selectionWeight = weightsArr[userSelection];
        double currSelectionAvg = gradesArr[userSelection];
        System.out.println("Enter the current total points in this weight category: ");
        str = br.readLine();
        double currPoints = Double.parseDouble(str);

        //do while that allows the user to test as many times as they want without having to re-run the program
        int repeat;
        double newAverage = 0;
        do {
            System.out.println("Enter 'what if' grade for " + selectionWeight + " weight: ");
            str = br.readLine();
            double hypoGrade = Double.parseDouble(str);

            System.out.println("Enter the number of points for this assignment: ");
            str = br.readLine();
            double hypoPoints = Double.parseDouble(str);

            double selectedWeightAvg = ((currSelectionAvg*currPoints) + (hypoGrade*hypoPoints))/(currPoints+hypoPoints);
            gradesArr[userSelection] = selectedWeightAvg;
            newAverage = getAvg(weightsArr, gradesArr);

            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println("\n\n\nYour new class average would be a " + df.format(newAverage));

            System.out.println("Would you like to enter another one?");
            System.out.println("Yes ('1') or No('0'): ");
            BufferedReader keepGoingQ = new BufferedReader(new InputStreamReader(System.in));
            //this is what allows the user to re-execute the 'what if' method without having to re run the program
            String quit = keepGoingQ.readLine();
            repeat = Integer.parseInt(quit);
        } while(repeat != 0);
    }

    public static void desiredClassAvg() throws IOException {
        double[] weightsArr = getNumericWeights();
        double[] gradesArr = getGrades(weightsArr);

        System.out.println("\n\n\nWhich assignment type do you have left?");
        for(int i = 0; i < weightsArr.length; i++) {
            System.out.println("Option " + i + ": weight of " + weightsArr[i]);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int userSelection = Integer.parseInt(str);

        double selectionWeight = weightsArr[userSelection];
        double currSelectionAvg = gradesArr[userSelection];
        System.out.println("Enter the current total points in this weight category: ");
        str = br.readLine();
        double currPoints = Double.parseDouble(str);

        System.out.println("Enter 'desired' grade: ");
        str = br.readLine();
        double desiredGrade = Double.parseDouble(str);

        System.out.println("Enter the number of points remaining for this assignment: ");
        str = br.readLine();
        double hypoPointsRem = Double.parseDouble(str);

        double partialAvg = 0;
        for(int i = 0; i < gradesArr.length; i++) {
            if(i != userSelection) {
                partialAvg += weightsArr[i] * gradesArr[i];
            }
        }

        double earnedPoints = (currSelectionAvg * currPoints)/100;
        double totalPoints = hypoPointsRem + currPoints;

        double requiredWeightAvg = ((desiredGrade - partialAvg)/selectionWeight)/100;
        double requiredAvg = (requiredWeightAvg * totalPoints) - earnedPoints;

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("\n\n\nYour would need to get a " + df.format(requiredAvg) + "% on the rest of those"
                + " assignments to get a " + df.format(desiredGrade) + "% in the class");

    }

    public static double getAvg(double[] weightsArr, double[] gradesArr) {
        double ovrAvg = 0;
        //iterating through each array
        //multiplying the grade avg by its corresponding weight and adding all these values together
        for(int i = 0; i < weightsArr.length; i++) {
            ovrAvg += weightsArr[i]*gradesArr[i];
        }
        return ovrAvg;
    }

    public static void aceOut() throws IOException {
        double[] weightsArr = getNumericWeights();
        double[] gradesArr = getGrades(weightsArr);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        int[] currentPoints = new int[weightsArr.length];
        for(int i = 0; i < weightsArr.length; i++) {
            System.out.println("Enter the current number of completed points for weight " + i + ": weight of " + weightsArr[i]);
            str = br.readLine();
            currentPoints[i] = Integer.parseInt(str);
        }
        int[] assignRem = new int[weightsArr.length];
        for(int i = 0; i < weightsArr.length; i++) {
            System.out.println("Enter the number of points remaining for weight " + i + ": weight of " + weightsArr[i]);
            str = br.readLine();
            assignRem[i] = Integer.parseInt(str);
        }
        double[] newAvgs = new double[weightsArr.length];
        for(int i = 0; i < weightsArr.length; i++) {
            newAvgs[i] = (((gradesArr[i]/100)*currentPoints[i])+assignRem[i])/(currentPoints[i] + assignRem[i]);
        }
        double newOvrAvg = getAvg(weightsArr, newAvgs)*100;

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Acing out would make your new average a " + df.format(newOvrAvg) + "%\n\n");
    }
}
