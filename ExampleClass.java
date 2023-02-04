import java.util.Scanner;

public class ExampleClass {
    public static void main(String args[]) {
        /**
         * calling the getWeights() method first
         *      this class returns an array (bucket/collection of values) with the
         *      number weights (weightsArr.length gives this number)(the weights
         *      are how your overall average are divided up)
         *
         * this returned array of weights is stored on the same line that the method is called from
         *      in the variable weightsArr
         *
         * we then use this weightsArr variable when calling the getGrades() method
         *      see how weightsArr is passed as a parameter in the () for getGrades()
         *      getGrades() returns another array (bucket of stuff) populated with the % average of
         *      each weighting category
         *      this returned array is stored in the gradesArr array
         *
         * the gradesArr and weightsArr (the two arrays created from what was returned from the method calls)
         *      are then passed as parameters (stuff in parentheses) to the getOverallAvg() method
         *      this method returns nothing (return type void) and it prints out the users overall class average
         *
         * we are using double arrays here because you want decimal point precision (.2, 92.75, etc.)
         *      int arrays can only store whole, integer values (10, 5, etc.)
         *
         * main is the only method that is automatically run, the rest of the methods will not be run
         *      unless they are called from main, or another method that has been called
         */
        double[] weightsArr = getWeights();
        double[] gradesArr = getGrades(weightsArr);
        getOverallAvg(weightsArr, gradesArr);
    }

    /**
     *
     * @returns a double array full the weight values
     *      example of how this could look would be weightAr = [.2, .5, .2, .1]
     * has no parameters
     */
    public static double[] getWeights() {
        //initializing scanner
        Scanner scnr = new Scanner(System.in);
        //getting number of different weights
        System.out.println("Enter number of grade weights: ");
        //retrieving user input
        int numWeights = scnr.nextInt();

        //declaring array with length = numWeights
        double arr[] = new double[numWeights];

        //declaring variables needed in loop
        double weight = 0;
        double sum = 0;
        //for loop that starts at 0 (i = 0), runs until i reaches the end of the array (i < numWeights)
        //and increments by 1 (i++)
        for(int i = 0; i < numWeights; i++) {
            //getting the weight values                    printing out weight index when asking (i + 1)
            System.out.println("Enter the weight value (eg. .2 for 20%) of weight " + (i+1) + ": ");
            weight = scnr.nextDouble();
            //validating user input
            if (weight > 1 || weight < 0) {
                //making sure user did not enter weights that are greater than 1 or less than 0
                System.out.println("Please enter a valid weight less than 1 and greater than 0.");
                //going back one iteration so that user does not lose progress and have to restart
                i--;
            } else {
                //if valid weight is entered, add it to array at index i
                arr[i] = weight;
            }
            //validating more input
            //this is checking if it is the last iteration
            //(we know the last iteration will be when i = numWeights bc that is
            //the last index
            if (i == numWeights - 1) {
                //summing up values of weights entered
                //resetting the value of sum for each time this process happens
                sum = 0;
                for (int j = 0; j < numWeights; j++) {
                    sum += arr[j];
                }
                //if the sum of the entered weights does not = 1, ask user to enter again
                //restart iterations (i = 0), takes user back to beginning of for loop
                if (sum != 1) {
                    System.out.println("Please enter weights that add up to 1");
                    i = -1;
                }
            }
        }
        //returning array with weight values that sum up to 1
        return arr;
    }

    /**
     *
     * @param weightsArr this is the array of weights which is passed in as parameter
     *                   (so that the method has access to it)
     * @return another double array gradesArr which is an array of grade percentages for each weight
     *          these two arrays match their weights to percentages based on the index
     */
    public static double[] getGrades(double[] weightsArr) {
        //initializing scanner
        Scanner scnr = new Scanner(System.in);

        //declaring variable
        double gradeAvg = 0;
        //declaring new array of length = number of weights in weightsArr
        double[] gradesArr = new double[weightsArr.length];
        //for loop starting at 0 (i=0), iterates through to end of array (weightsArr.length)
        //and increments by 1 (i++)
        for(int i = 0; i < weightsArr.length; i++) {
            //getting grade % from user
            System.out.println("Enter your grade average (eg. 92.5) for weight " + (i+1) + " of " + weightsArr[i] + ": ");
            gradeAvg = scnr.nextDouble();
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

    /**
     * this method calculates the users overall grade average given the two arrays as parameters
     *
     * @param weightsArr array full of weights
     * @param gradesArr array full of grade %s
     *
     * this method has no return (void)
     */
    public static void getOverallAvg(double[] weightsArr, double[] gradesArr) {
        double ovrAvg = 0;
        //iterating through each array
        //multiplying the grade avg by its corresponding weight and adding all these values together
        for(int i = 0; i < weightsArr.length; i++) {
            ovrAvg += weightsArr[i]*gradesArr[i];
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        //printing out users average
        System.out.println("Your overall average is " + ovrAvg + "%");
    }
}
