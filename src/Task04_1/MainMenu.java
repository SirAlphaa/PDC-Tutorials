package Task04_1;

import java.util.HashMap;
import java.util.Scanner;

// import Task03_2.MathQuiz;

public class MainMenu {
    
    public static void main(String[] args) {
        
        Scanner uInput = new Scanner(System.in);
        HashMap<String, Integer> records = new HashMap<>();
        records = FileInterface.readRecords();
        String name, temp;
        Integer score;
        // System.out.print(records);
        
        //Ask user to input name
        BetterMathQuiz.clearScreen();
        System.out.print("Kia ora!\nPlease input your name | ");
        name = uInput.nextLine();
        
        //Check whether existing or not
        BetterMathQuiz.clearScreen();
        if (records.containsKey(name)) {
            System.out.print("Welcome back " + name + ". You currently have " + records.get(name) + " points" + "!\n\nWould you like to start the game? (Y = Yes | N = No) | ");
            temp = uInput.nextLine();
            if (temp.trim().equalsIgnoreCase("N")) {
                exitGame(records, name);
            }
        } else {
            System.out.print("New User Detected!\nWould you like to continue as " + name + "? (Y = Yes | N = No) | ");
            temp = uInput.nextLine();
            if (temp.trim().equalsIgnoreCase("n")) {
                exitGame();
            }
            BetterMathQuiz.clearScreen();
            records.put(name, 0);
            System.out.print("Welcome " + name + ". You currently have " + records.get(name) + " points!\n\nWould you like to start the game? (Y = Yes | N = No) | ");
            temp = uInput.nextLine();
            if (temp.trim().equalsIgnoreCase("n")) {
                FileInterface.writeRecords(records);
                exitGame(records, name);
            }
        }

        //start Math game with
        score = BetterMathQuiz.MathGame(records.get(name));
        
        //update records and write to file
        BetterMathQuiz.clearScreen();
        records.replace(name, score);
        // System.out.println(score);
        // System.out.println(records);
        FileInterface.writeRecords(records);
        uInput.close();
        exitGame(records, name);
    }

    public static void exitGame(HashMap<String, Integer> records, String userName) {
        BetterMathQuiz.clearScreen();
        System.out.println("Good Bye " + userName + " <3\n\nYour currect score is " + records.get(userName) + "\n");
        System.exit(0);
    }

    public static void exitGame() {
        BetterMathQuiz.clearScreen();
        System.out.println("Good Bye :(");
        System.exit(0);
    }
}