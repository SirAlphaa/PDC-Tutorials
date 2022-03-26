package Task01_2;

/**
 *
 * @author SirAl
 */
public class Rectangle extends Shape {
    
    double len, wid;

    public Rectangle (double len, double wid) {
        super("Rectangle");
        this.len = len;
        this.wid = wid;
    }

    public Rectangle (double side) {
        super("Squre");
        this.len = side;
        this.wid = side;
    }

    @Override
    public void calculateArea() {
        this.area = len * wid;
    }

}
