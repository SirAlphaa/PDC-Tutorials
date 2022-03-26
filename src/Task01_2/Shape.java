package Task01_2;

public abstract class Shape {

    public String shapeName = "";
    public double area = 0;

    public Shape(String name) {
        this.shapeName = name;
    }

    public void printInfo() {
        System.out.println("Shape | " + this.shapeName);
        System.out.printf("Area  | %.3f \n", this.area);
    }

    public void setName(String newName) {
        this.shapeName = newName;
    }

    //please be noted that this is an abstract function
    public abstract void calculateArea();

}

