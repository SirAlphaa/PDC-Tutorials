package Task01_2;

/**
 *
 * @author SirAlpha
 */
public class Squre extends Rectangle {
    
    double side;

    public Squre(double side) {
        super(side);
        this.side = side;
    }

    @Override
    public void calculateArea() {
        this.area = side * side;
    }

}
