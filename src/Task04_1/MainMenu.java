package Task04_1;

import java.util.HashMap;
import java.util.Scanner;

public class MainMenu {
    
    public static void main(String[] args) {
        
        Scanner uInput = new Scanner(System.in);
        HashMap<String, Integer> records = new HashMap<>();
        records = FileInterface.readRecords();
        String name;
        // System.out.print(records);
        
        //Ask user to input name
        BetterMathQuiz.clearScreen();
        System.out.print("Kia ora!\nPlease input your name | ");
        name = uInput.nextLine();
        
        //Check whether existing or not
        BetterMathQuiz.clearScreen();
        if (records.containsKey(name)) {
            System.out.print("Welcome back " + name + "!\n\nWould you like to start the game? (Y = Yes | N = No)  | ");
            if (name.trim().equalsIgnoreCase("N")) {
                System.out.println("Good Bye");
                // uInput.close();
                // TODO: uncomment line above
                System.exit(0);
            }
        } else {
            System.out.print("New User Detected!");
        }
    }
}