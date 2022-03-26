package Task01_2;
import java.util.Scanner;

/**
 *
 * @author SirAl
 */
public class ShapeCalculator2 {

    public static void main(String[] args) {
        
    System.out.println("Welcome to the AMAZING shape area calculator \n \nPlease input a number for the following \n (1) Rectangle \n (2) Circle \n (3) Squre \n");
    Scanner scan = new Scanner(System.in);
    String userInput = scan.nextLine();

    try {
        int userOption = Integer.parseInt(userInput);
        
        if ((userOption > 3) || (userOption < 1)) {
            userOption = 4;
        }

        switch (userOption) {
            case 1:
                System.out.print("Length Input: ");
                userInput = scan.nextLine();
                double len = Double.parseDouble(userInput);
                
                System.out.print("Width Input: ");
                userInput = scan.nextLine();
                double wid = Double.parseDouble(userInput);

                Shape recObj = new Rectangle(len, wid);
                recObj.calculateArea();
                recObj.printInfo();
                break;

            case 2:
                System.out.print("Radius Input: ");
                userInput = scan.nextLine();
                double rad = Double.parseDouble(userInput);

                Shape cirObj = new Circle(rad);
                cirObj.calculateArea();
                cirObj.printInfo();
                break;

            case 3:
                System.out.print("Side Input: ");
                userInput = scan.nextLine();
                double side = Double.parseDouble(userInput);

                Shape squObj = new Squre(side);
                squObj.calculateArea();
                squObj.printInfo();
                break;
            
            case 4:
                System.out.print("Wrong Input | Inputed Number not in range ");
        }
    } 
    catch (NumberFormatException e) {
        System.out.println("Invaild Input | Not a interger");
    }
    scan.close();
} 
}
