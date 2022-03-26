package Task03_2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class MathQuiz {
    
    public static void main(String[] args) {
        
       int score = 0;
       int rounds = 0;
       Scanner uInput = new Scanner(System.in);
       MathQuiz quiz = new MathQuiz();
       boolean Looper = true;

       while (Looper) {
            try {
                System.out.print("How many rounds would you like to play? | ");
                rounds = uInput.nextInt();
                Looper = false;
            } catch (InputMismatchException e) {
                System.out.println("please input a number only.");
                uInput.nextLine();
            }
       }

       clearScreen();

       System.out.println("Let the games begin!!\n\n");

       while (rounds != 0) {
        
            double actualAns = 0.0, userAns = 0.0;
            actualAns = quiz.newQuestion();
            
            Looper = true;
            while (Looper) {
                System.out.print("You answer? | ");
                String input = uInput.next();
                if (input.trim().equalsIgnoreCase("x")) {
                    clearScreen();
                    System.out.println("Your final Score is | " + score + "\n\n\n\n\n");
                    uInput.close();
                    System.exit(0);                    
                }
                try {
                    userAns = Double.parseDouble(input);
                    Looper = false;
                } catch (InputMismatchException e) {
                    System.out.println("Invaild input, try again lol\n");
                    uInput.nextLine();
                }
            }

            score = score + quiz.checkAnswer(actualAns, userAns);
            System.out.println("Current Score   | " + score + "\n");
            rounds--;

       }
       uInput.close();
       System.out.println("\nGame Complete");
    }

    public int checkAnswer(Double realAns, Double userAns) {

        int score;

        if ((realAns - userAns) < 0.5) {
            score =+ 10;
            clearScreen();
            System.out.println("Correct!");
        } else {
            score =- 10;
            clearScreen();
            System.out.println("Wrong :(");
        }

        return score;
    }

    public int randomNumber (int upperNumber) {
        
        int output = 0;
        Random rand = new Random();

        output = rand.nextInt(upperNumber + 1);

        return output;
    }

    public double newQuestion () {
        
        int number1 = this.randomNumber(100);
        int number2 = this.randomNumber(100);
        String operation = "";
        double answer = 0.0;

        //1 = +     2 = -   3 = /   4 = *
        switch (this.randomNumber(3) + 1) {
            case 1:
                operation = " + ";
                answer = number1 + number2;
                break;

            case 2:
                operation = " - ";
                while (number2 > number1) {
                    number2 = this.randomNumber(100);
                }
                answer = number1 - number2;
                break;
            
            case 3:
                operation = " * ";
                answer = number1 * number2;
            
            case 4:
                operation = " / ";
                while (number2 == 0 && number2 > number1) {
                    number2 = this.randomNumber(100);
                }
                answer = number1 / number2;

            default:
                break;
        }

        System.out.println(number1 + operation + number2 + " = ");

        return answer;
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
