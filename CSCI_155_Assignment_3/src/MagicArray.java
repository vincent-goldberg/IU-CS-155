/**
 * A program that replaces all instances of a given "magic number"
 * in a user-defined integer array with zeros. It displays the array
 * before and after modification using a validated, user-friendly interface.
 * 
 * @author Red Team
 * @version 2.1
 * @date 06/25/2025
 */

// Package Imports
import java.util.Scanner;
import java.util.Arrays;

public class MagicArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scan for user input

        // Ask user for size of the array (since it's not an Array list it is not dynamic)
        int arraySize;
        while (true) {
        	System.out.print("Please enter the size of the array: ");
        	if (sc.hasNextInt()) {
        		arraySize = sc.nextInt();
        		if (arraySize >= 0) break;
        		else System.out.println("Array size must be a positive integer.");
        	} else {
        		System.out.println("Invalid input! Please enter an integer.");
        		sc.next(); // Discard invalid input
        	}
        }
        
        // Get array elements from user
        int[] userArray = new int[arraySize]; 
        System.out.println("Please enter " + arraySize + " integers for the array:");
	    for (int i = 0; i < arraySize; i++) {
	    	  while (true) {
	    		  System.out.print("Element " + (i + 1) + ": ");
	    		  if (sc.hasNextInt()) {
	    			  userArray[i] = sc.nextInt();
	    			  break;
	    		  } else {
	    			  System.out.println("Invalid input! Please enter an integer.");
	    			  sc.next(); // discard invalid input
	    		  }
	    	  }
	      }


        // Get the magic number from the user 
	    int magicNumber;
	    while (true) {
	    	System.out.print("Please enter the magic number:");
	    	if (sc.hasNextInt()) {
	    		magicNumber = sc.nextInt();
	    		break;
	    	} else {
	    		System.out.println("Invalid input! Please enter an integer.");
                sc.next(); // discard invalid input
	    	}
	    }
        
	    // Modifying duplicate array to replace magic number with zeros
	    int modifiedArray[] = magicReplace(userArray, magicNumber);
        // Displaying the results to the user
        System.out.println("\nOriginal Array: " + Arrays.toString(userArray));
        System.out.println("Magic Number: " + magicNumber);
        System.out.println("Modified Array: " + Arrays.toString(modifiedArray));
        
        sc.close();

    }//end of main
    
    /**     magicRepalce()
     * Replaces all instances of magicNumber in the array with zero.
     * Returns a new array without modifying the original.
     *
     * @param theArray     original array
     * @param magicNumber  number to be replaced with zero
     * @return             new array with replacements
     */
    public static int[] magicReplace(int[] theArray, int magicNumber) {
        int [] updatedArr = Arrays.copyOf(theArray, theArray.length);
    	for (int i = 0; i < updatedArr.length; i++) {
            if (updatedArr[i] == magicNumber) {
            	updatedArr[i] = 0;
            }
        }
        return updatedArr;
    }//end of method magicReplace
    
}//end of class
