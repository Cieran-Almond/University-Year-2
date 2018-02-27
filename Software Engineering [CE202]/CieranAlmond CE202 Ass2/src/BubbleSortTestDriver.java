/**
 * Created by ca16873 on 22/11/2017.
 */

//Cieran Almond
public class BubbleSortTestDriver extends ArithmeticException {
    private static int POFOD = 0;
    private static int count = 0;
    private static int success = 0;
    //initialise variables
    /**
     * Main function calculating the POFOD on the basis of the return statement
     * results of all test cases
     * POFOD is being printed out
     */
    public static void main(String[] args) {
        //initalise lists to be tested
        int[] test1 = {5, 1, 12, -5, 16};
        int[] test2 = {5};
        int[] test3 = {};

        //methods for studs
        System.out.println("Test 1 is : " + test(test1));
        System.out.println("Test 2 is : " + test(test2));
        System.out.println("Test 3 is : " + test(test3));
        // if count equals same as success, print = 0, else divide count by success, and print POFOD equals 0, number of counts, and POFOD value.
        try {
            if (count == success) {
                System.out.println("POFOD is 0");
            } else {
                System.out.println("Count : " + count);
                System.out.println("Successes: " + success);
                POFOD = count / success;
                System.out.println("POFOD is : " + Integer.toString(POFOD)); //output your POFOD
            }
            }
        catch(ArithmeticException e){
                System.out.println("Can't divide count by 0 ");
            }
        }

    // increment count and compare unsorted list to sorted list after run through bubblesorft, if its the same increment success and return true
    public static boolean test(int[] test) {
        count++;
        if(BubbleSortTestOracle.bubble_sort( BubbleSort.bubble_sort(test))){
            success++;
            return true;
        }
        return false;
    }

}