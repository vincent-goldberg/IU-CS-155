/**
 * Demonstrating the use of 2D arrays with additional matrix utilities.
 * Provides methods to display, sum, average, and analyze 2D arrays.
 * 
 * @author Red Team
 * @version 1.1
 * @date 29 June 2025
 */

public class TwoDArraysDemoEnhanced {
        public static void main (String args[]){

            // First array
            int[][] firstArray = {
            		{10, 20, 45},
            		{11, 15, 17}
            };
          

            // Second array
            int[][] secondArray =
            {
                { 1, 2, 3 },
                { 4, 5, 6 }
            };

            // Third array
            int thirdArray[][] = {
                { 1, 2 },
                { 3 }, 
                { 4, 5, 6 }
            };

            // Fourth array of zeros
            int[][] fourthArray = new int[3][3];

            //use buildOuput to display array contents in 2D format
            System.out.println( "Values in firstArray by row are:" );
            buildOutput( firstArray );
            System.out.println( "\nValues in secondArray by row are:" );
            buildOutput( secondArray );
            System.out.println( "\nValues in thirdArray by row are:" );
            buildOutput( thirdArray );
            System.out.println( "\nValues in fourthArray by row are:" );
            buildOutput( fourthArray );

            //begin to use new methods on the existing arrays
            System.out.println( "\nThe sum of the first array is: " + getSum(firstArray));
            System.out.println( "\nThe average of the second array is: " + getAverage(secondArray));
            System.out.println( "\nThe smallest value in the first row of the third array is: " + getSmallestInFirstRow(thirdArray));
            System.out.println( "\nThe fourth rrray, initalized to 5 when row and column match:" );
            initializeArray(fourthArray);
            buildOutput( fourthArray );
            System.out.println( "");

    }// -------- End main() -------

    /**
    * Displays the contents of a 2D array in matrix format.
    * @param array
    */
    public static void buildOutput( int array[][] ) {
    	if (array == null || array.length == 0) return; // Check for empty array
    	// loop through array's rows
        for ( int row = 0; row < array.length; row++ ) {
        // loop through columns of current row
            for ( int column = 0; column < array[row].length; column++ ) {
                //note print instead of print line to keep values for this row on the current line
                System.out.print( array[ row ][ column ] + " " );
            }
            System.out.println( ); //empty line for console readability
        }
    } // End buildOutput


    /**
     * Returns the sum of all values in a 2D array.
     * @param array the 2D array of integers
     * @return the total sum of elements
     */
    public static int getSum( int array[][] ){
    	if (array == null) return 0; 

        int sum = 0;
        // loop through array's rows
        for (int[] row: array) {
            // loop through columns of current row
            for (int val : row) {
                //add current value to sum
                sum += val;
            }
        }
        return sum;
    } // End getSum

    
    /**
     * Returns the average of all values in a 2D array.
     * @param array the 2D array of integers
     * @return the average of elements as a double
     */
    public static double getAverage(int array[][]){
    	if (array == null) return 0;
    	
        //get sum of input array
        int total = getSum(array);
        double count = 0.0; // Count of elements in array
        
        //loop through the rows
        for (int[] row : array) {
            //add the number of items in this row to the total length
            count += row.length;
        }
        
        return (count == 0) ? 0 : total / count;
    } // End getAverage

    public static int getSmallestInFirstRow(int array [][]){
    	if (array == null || array.length == 0 || array[0].length == 0) {
    		throw new IllegalArgumentException("First row is empty or array is null.");
    	}
        
    	
        int smallest = Integer.MAX_VALUE; // Largest integer value in Java
        for ( int column = 0; column < array[0].length; column++ ) {
            if (array[0][column] < smallest) {
                smallest = array[0][column]; // Update smallest if true
            }
        }
        return smallest;
    } // End getSmallestInFirstRow

    
    /**
     * Initializes a square array such that positions where row == column are set to 5, all others to 0.
     * @param array the 2D array to initialize
     */
    public static void initializeArray(int array[][]){
    	if (array == null) return;
    	
        // loop through the array's rows
        for ( int row = 0; row < array.length; row++ ) {
        // loop through the columns of current row 
            for ( int column = 0; column < array[row].length; column++ ) {
                array[row][column] = (row == column) ? 5 : 0; // If row/column equal, update to 5 otherwise update to 0
                }
            }
        }
    }
