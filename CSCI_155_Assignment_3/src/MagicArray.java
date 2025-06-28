/* 
 * Create a Method that accepts an integer array and another integer as magicNumber.
 * Replaces all instances of magicNumber in the input array with zeros. 
 * Returns a new array with modifications.
 *
 * @author: Team Red
 * @date 25JUN25
 * @version 2.0
 */

// Package Imports
import java.util.Scanner;
import java.util.Arrays;

public class MagicArray {

    public static void main(String[] args) {

        //Create a Scanner object
        Scanner sc = new Scanner(System.in);

        //Create an input for the size of the array (since it's not an Array list it is not dynamic)
        System.out.print("Please enter the size of the array: ");
        int input = sc.nextInt();
        int [] userArray = new int[input];

        //Create another input for the integers in the array
        System.out.print("Please enter " + input + " integers in the array: ");
        for (int i = 0; i < input; i++) {
            userArray[i] = sc.nextInt();
        }

        //We need to also grab the magic number from the user
        System.out.println("Please enter a second value to test the method: ");
        int second = sc.nextInt();
        //Print the values prior to invoking the method
        System.out.println("Your Array integers: " + Arrays.toString(userArray));
        System.out.println("Your magic value: " + second);

        //Print the result to the user
        System.out.println("Modified Array: " + Arrays.toString(magicReplace(userArray, second)));
        
        sc.close();

    }//end of main
    
    //Place method from Assignment instructions
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
