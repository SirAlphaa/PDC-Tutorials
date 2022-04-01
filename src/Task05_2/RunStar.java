package Task05_2;

public class RunStar {
    
    public static void main(String[] args) {
        
        Star theOject = new Star();

        Thread thread1 = new Thread(theOject);
        Thread thread2 = new Thread(theOject);

        thread1.start();
        thread2.start();

    }

}
