/**
 * A console-based course management program that allows users to add,
 * remove, list, and count computing courses using a menu-driven interface.
 * 
 * Courses are stored in a case-insensitive, non-duplicating ArrayList.
 * A computing course is defined as any course whose title starts with "COMP".
 * 
 * This program ensures input validation and provides a user-friendly experience.
 * 
 * @author Red Team
 * @version 1.1
 * @date 28 June 2025
 */

import java.util.Scanner;
import java.util.ArrayList;

public class RegistrarMenuArrayList {
    static ArrayList<String> courseList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean finished = false;
        int userChoice;

        while (!finished) {
            // Menu Display
            System.out.println();
            System.out.println("Course Management Menu");
            System.out.println("======================");
            System.out.println(" 1. Create a new course");
            System.out.println(" 2. Remove course from the list");
            System.out.println(" 3. Number of computing courses in the list");
            System.out.println(" 4. Display the current courses in the list");
            System.out.println(" 5. Exit");
            System.out.println();

            // Get the input from the user
            System.out.print("Please input your choice (1-5): ");
            if (input.hasNextInt()) {
                userChoice = input.nextInt();
                input.nextLine(); 
                if (userChoice >= 1 && userChoice <= 5) {
                    switch (userChoice) {
                        case 1:
                            createCourse(); break;
                        case 2:
                            removeCourse(); break;
                        case 3:
                            numComputingCourse(); break;
                        case 4:
                            displayCourse(); break;
                        case 5:
                            System.out.println("Thank you for using the Course Registrar. Goodbye!");
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

        input.close(); // Close scanner 
    }

    public static void createCourse() {
        while (true) {
            System.out.print("\nPlease enter the title of the course: ");
            String course = input.nextLine().trim().toUpperCase();
            
            if (course.isEmpty()) {
            	System.out.println("\nCourse name cannot be empty. Please try again.");
            	continue;
            }
            if (courseList.contains(course)) {
                System.out.println("\nThis course already exists. Please enter a new course.");
            } else {
                courseList.add(course);
                System.out.println("\nCourse added successfully!");
                break;
            }
        }
    }

    public static void removeCourse() {
        while (true) {
            System.out.print("\nPlease enter the title of the course to remove: ");
            String course = input.nextLine().trim().toUpperCase();
        	if (course.isEmpty()) {
            	System.out.println("\nCourse name cannot be empty.");
            	continue;
            }
            if (courseList.contains(course)) {
                courseList.remove(course);
                System.out.println("\nCourse was successfully removed from the list.");
                break;
            } else {
                System.out.println("\nThe course is not found in the list. Returning to main menu.");
                return;
            }
        }
    }

    public static void numComputingCourse() {
        int count = 0;
        for (String course : courseList) {
            if (course.startsWith("COMP")) {
                count++;
            }
        }
        System.out.println("\nNumber of computing courses (starting with 'COMP'): " + count);
    }

    public static void displayCourse() {
        if (courseList.isEmpty()) {
            System.out.println("\nNo courses currently in the list.");
        } else {
            System.out.println("\nCurrent courses:");
            for (String crs : courseList) {
                System.out.println(" - " + crs);
            }
        }
    }
}
