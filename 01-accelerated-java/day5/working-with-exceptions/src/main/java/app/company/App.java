package app.company;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
//    UNCHECKED EXCEPTIONS
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userInput;
        int number = 0;

        do {
            System.out.println("Please enter a number between 1 and 10");
            userInput = scan.nextLine();
            try {
                number = Integer.parseInt(userInput);
            } catch (NumberFormatException exc) {
                System.out.println("You must enter a Integer");
            } catch (Exception exc) {
                System.out.println(exc.getMessage());
            } finally {
                System.out.println("end of loop body");
            }
        } while (number < 1 || number > 10) ;

            System.out.println("Thanks for playing!  You chose " + number);
        }
    }

//    CHECKED EXCEPTIONS
//    public static void main(String[] args) {
//        try {
//            PrintWriter writer = new PrintWriter(new FileWriter("/Desktop/output.txt"));
//
//            writer.println("File line 1");
//            writer.println("File line 2");
//
//            writer.flush();
//            writer.close();
//        } catch (IOException exc) {
//            System.out.println("An error occurred: " + exc.getMessage());
//        } finally {
//            System.out.println("Finishing up now.  Have a nice day.");
//        }
//    }
//}
