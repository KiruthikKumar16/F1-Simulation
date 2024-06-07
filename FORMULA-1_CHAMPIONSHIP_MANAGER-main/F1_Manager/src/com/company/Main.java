package com.company;

import java.io.IOException;
import java.util.Scanner;
public class Main {// Main class of the application
    /*
    * ATTHANAYAKE WASALA MUDALI WALAWWE ISURU BANDARA ATTHANAYAKE
    Uow No: w1810007
    IIT No	:20200265
    “ I confirm that I understand what plagiarism is and have read and understood the section on Assessment Offences in
    * the Essential Information for Students. The work that I have submitted is entirely my own. Any work from other authors is duly referenced and acknowledged.”
    */
    //------------------------------------------------------------ Main class-------------------------------------------------
    public static void main(String[] args) throws IOException { // Main method of the application

        Formula1Championshipmanager a = new Formula1Championshipmanager(); // link between main and Formular1championshipmanager
        Scanner input = new Scanner(System.in);

        // menu consists of a switchcase
        boolean menuChoice = true; //this is a boolean
        String choice;
        a.readfile(); // getting the saved data
        while (menuChoice) {
            //System.out.print("-------------------Formula1 Championship Management System----------------\n");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("                                             FORMULAR 1 RACING CAR CHAMPIONSHIP Management System.                                        ");
            System.out.println("==========================================================================================================================");
            System.out.println("Enter 1 to add  Driver : ");
            System.out.println("Enter 2 change a Driver: ");
            System.out.println("Enter 3 to delete a driver:");
            System.out.println("Enter 4 to add a race:");
            System.out.println("Enter 5 to view statistics by name of a driver:");
            System.out.println("Enter 6 to view table:");
            System.out.println("Enter 7 to save the driver:");
            System.out.println("Enter 8 to view the GUI");
            System.out.println("Enter Q to Quit:");
            System.out.print("---------------------------------------------------------------------------------------------------------------------------\n");
            System.out.println("Enter your choice:");
            choice = input.next();

            switch (choice) {
                //switch case including the letters in menu and the methods.
                case "1":
                    //add adriver
                    a.createDriver();
                    break;
                case "2": //change a driver
                    a.changeDriver();
                    break;
                case "3": //delete a driver
                    a.deleteDriver();
                    break;
                case "4": //add races
                    a.addRace();
                    break;
                case "5": //view statistics
                    a.viewstatistics();
                    break;
                case "6": //view tables
                    a.viewtable();
                    break;
                case "7": //saves the file
                    a.savefile();
                    break;
                case "Q": //Quits from the program
                    a.exit();
                    break;
                case "8": // loading the gui
                    new Formular1GUI(a);
                    break;
                default:
                    System.out.println("Please enter valid input"); //if invalid input
            } //end of switch case including the letters in menu and the methods.
        }
    }
}