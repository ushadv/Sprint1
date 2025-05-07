package com.loan;

import java.io.Console;
import java.util.Scanner;

public class MainOperation {
    static Scanner sc = new Scanner(System.in);// Scanner object to read user input
    private static final String ADMIN_USERNAME = "admin";// Admin username constant
    private static final String ADMIN_PASSWORD = "admin123";// Admin password constant

    public static void main(String[] args) {
    	
    	// Calling adminLogin method to verify login before proceeding
        if (adminLogin()) {
            mainOps(); // Proceed to menu only after successful login
        } else {
            System.out.println("Too many failed attempts. Exiting...");// If login fails after multiple attempts, exit the program
        }
    }

    public static boolean adminLogin() {
        Console console = System.console();// Get the system console for secure password input

        int attempts = 3; // Allow a maximum of 3 attempts to login

        // Loop to give the user multiple attempts to enter the correct credentials
        while (attempts > 0) {
            System.out.println("==== Admin Login ===="); // Print login prompt

            String username;
            String password;

            if (console != null) {// Check if console is available (for secure input)
                username = console.readLine("Enter Username: ");// Read username securely
                char[] passwordChars = console.readPassword("Enter Password: ");// Read password securely
                password = new String(passwordChars); // Convert password char array to string
            } else {
                // Fallback for IDEs
                System.out.print("Enter Username: ");// Read username normally
                username = sc.nextLine();
                System.out.print("Enter Password: ");// Read password normally
                password = sc.nextLine();
                
            }
            // Check if the entered credentials match the admin credentials
            if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                System.out.println("Login successful!\n");
                return true;// Return true if login is successful
            } else {
            	// Decrease attempts and notify the user of the remaining attempts
                attempts--;
                System.out.println("Invalid credentials. Attempts left: " + attempts + "\n");
            }
        }

        return false; // Return false after all failed attempts
    }

    public static void mainOps() {
    	
    	 // Infinite loop to continuously show the main operation menu until the user exits
        while (true) {
            System.out.println("==== SBI Loan Management System ====");// Print the main menu heading
            
            // Display available operations
            System.out.println("Press 1. Branch Details");
            System.out.println("Press 2. Loan Details");
            System.out.println("Press 3. Customer Details");
            System.out.println("Press 4. EMI Details");
            System.out.println("Press 5. Employee Details");
            System.out.println("Press 6. Department Details");
            System.out.println("Press 7. Exit");
            System.out.println("Enter your choice:");

            int input = sc.nextInt();  // Read user input for operation selection

            // Switch case to execute appropriate operation based on user choice
            switch (input) {
                case 1:
                    AllOperations.BranchOperations(); // Call Branch Operations
                    break;
                case 2:
                    AllOperations.LoanOperations(); // Call Loan Operations
                    break;
                case 3:
                    AllOperations.CustomerOperations(); // Call Customer Operations
                    break;
                case 4:
                    AllOperations.EmiOperations(); // Call Emi Operations
                    break;
                case 5:
                    AllOperations.EmployeeOperations(); // Call Employee Operations
                    break;
                case 6:
                    AllOperations.DepartmentOperations(); // Call Department Operations
                    break;
                case 7:
                    System.out.println("Thank you for using the system!");
                    System.exit(0); // Exit the program
                default:
                    System.out.println("Wrong input. Try again."); // Print error message on invalid input
            }
            

            System.out.println("=======================================");
        }
    }
}