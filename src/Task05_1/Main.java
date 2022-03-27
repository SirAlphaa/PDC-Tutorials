package Task05_1;

public class Main {
    
    public static void main(String[] args) {
        Counter counterEven = new Counter(0);
        Counter counterOdd = new Counter(1);

        Thread thread1 = new Thread(counterEven);
        Thread thread2 = new Thread(counterOdd);

        thread1.start();
        thread2.start();
    }

}
