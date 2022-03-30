package Task05_2;

public class Main2 {
    public static void main(String[] args) {
        Star starA = new Star("Spaces");
        Star starB = new Star("Stars");

        Thread thread1 = new Thread(starA);
        Thread thread2 = new Thread(starB);

        thread1.start();
        thread2.start();
    }
}