/**
 * A menu-driven program for managing a list of course names using a one-dimensional array.
 * Demonstrates array resizing, input validation, and string processing in Java.
 * 
 * @author Red Team
 * @version 2.0
 * @date 29 June 2025
 */

import java.util.Scanner;

public class RegistrarMenuArray {
	static Scanner input = new Scanner(System.in);
	
    public static void main(String[] args) {
    	String[] courseList = new String[0];
    	boolean finished = false;
    	
    	while (!finished) {
            System.out.println();
            System.out.println("Registrar Menu");
            System.out.println("====================");
            System.out.println(" 1. Create a new course");
            System.out.println(" 2. Remove a course from the list");
            System.out.println(" 3. Number of Computing courses in the list");
            System.out.println(" 4. Display the current courses in the list");
            System.out.println(" 5. Exit");
            System.out.println();
            
            System.out.print("Please input your choice (1-5): ");
            if (input.hasNextInt()) {
            	int userChoice = input.nextInt();
            	input.nextLine(); 
            	
            	if (userChoice >= 1 && userChoice <=5) {
            		switch (userChoice) {
	                    case 1:
	                        courseList = createCourse(courseList); break;
	                    case 2:
	                        courseList = removeCourse(courseList); break;
	                    case 3:
	                        numComputingCourses(courseList); break;
	                    case 4:
	                        displayCourses(courseList); break;
	                    case 5:
	                        System.out.println("\nThank you for using the Course Registrar. Goodbye!");
	                        finished = true; break;
            		}
            	} else {
            		System.out.println("\nInvalid input! Please enter a number from 1 to 5.");
            	}
            } else {
                System.out.println("\nInvalid input! Please enter a number from 1 to 5.");
                input.nextLine(); // clear invalid input
            }
            
            System.out.println("\n----------------------------------------");
    	}
    	
    	input.close();
    } // End of main
    
    
    /**
     * Adds a new course to the array if it does not already exist.
     * Course names are compared case-insensitively.
     *
     * @param array the current list of courses
     * @return a new array with the course added, or the original array if the course already exists or input is empty
     */
    public static String[] createCourse(String[] array) {
    	System.out.print("\nPlease enter the title of the course: ");
    	String course = input.nextLine().trim().toUpperCase();
    	
    	if (course.isEmpty()) {
    		System.out.println("\nCourse name cannot be empty.");
    		return array;
    	}
    	
    	// Check for duplicates
    	for (String crs : array) {
    		if (crs.equalsIgnoreCase(course)) {
    			System.out.println("\nThat course already exists. It was not added again.");
    			return array;
    		}
    	}
    	
    	// Add new course
    	String[] newArray = new String[array.length + 1];
    	System.arraycopy(array, 0, newArray, 0, array.length);
    	newArray[array.length] = course;
    	System.out.println("\n" + course + " added to course list.");
    	
    	return newArray;
    } // End of createCourse
    
    
    /**
     * Removes a course from the array by name.
     * If the course is not found, the original array is returned unchanged.
     *
     * @param array the current list of courses
     * @return a new array with the course removed, or the original array if not found or input is empty
     */
    public static String[] removeCourse(String[] array) {
    	System.out.print("\nPlease enter the title of the course to remove: ");
    	String course = input.nextLine().trim().toUpperCase();
    	
    	if (course.isEmpty()) {
    		System.out.println("\nCourse name cannot be empty.");
    		return array;
    	}
    	
    	// Get index of course if it exist
    	int index = -1;
    	for (int i = 0; i < array.length; i++) {
    		if (array[i].equalsIgnoreCase(course)) {
    			index = i;
    			break;
    		}
    	}
    	if (index == -1) {
    		System.out.println("\nThe course was not found in the list.");
    		return array;
    	}
    	
    	// Deleting course if it existed
    	String[] newArray = new String[array.length - 1];
    	System.arraycopy(array, 0, newArray, 0, index); // Copy elements before the removed course
    	System.arraycopy(array, index + 1, newArray, index, array.length - index - 1); // Copying everything after the course
    	System.out.println("\nThe course was successfully removed from the list.");
    	
    	return newArray;
    } // End removeCourse
    
    
    /**
     * Counts and displays the number of computing courses in the list.
     * A computing course is defined as one whose name starts with "COMP" (case-insensitive).
     *
     * @param array the current list of courses
     */
    public static void numComputingCourses(String[] array) {
    	int count = 0;
    	
    	for (String crs : array) {
    		if (crs.length() >= 4 && crs.substring(0, 4).equalsIgnoreCase("COMP")) {
    			count ++;
    		}
    	}
    	System.out.println("\nThe total computing courses in the list is: " + count);
    } // End numComputingCourses
    
    
    /**
     * Displays all courses currently stored in the array.
     *
     * @param array the current list of courses
     */
    public static void displayCourses(String[] array) {
    	if (array.length == 0) {
    		System.out.println("\nNo courses are currently in the list.");
    	} else {
    		System.out.println("\nThe current courses in the system:");
    		for (String crs: array) {
    			System.out.println(" - " + crs);
    		}
    	}
    } // End displayCourses
}
    