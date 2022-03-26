package Task01_2;

/**
 *
 * @author SirAl
 */
public class Circle extends Shape {

    double rad; 

    public Circle(double r) {
        super("Circle");
        this.rad = r;    
}

    @Override
    public void calculateArea(){
        this.area = rad * rad * Math.PI;
    }
}
