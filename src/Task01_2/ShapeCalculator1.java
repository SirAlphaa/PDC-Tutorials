package Task01_2;

/**
 *
 * @author SirAl
 */
public class ShapeCalculator1 {

    public static void main(String[] args) {

        Shape cirObj = new Circle(2.5);
        Shape recObj = new Rectangle(12, 16.5);
        Shape squObj = new Squre(3.3);

        cirObj.calculateArea();
        recObj.calculateArea();
        squObj.calculateArea();
        
        cirObj.printInfo();
        recObj.printInfo();
        squObj.printInfo();

    }

}
