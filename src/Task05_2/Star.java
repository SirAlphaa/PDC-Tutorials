package Task05_2;

public class Star implements Runnable {

    String decide;

    @Override
    public void run() {
        int max = 9;
        System.out.println("Figure:");
        try {
            printStar(max,this.decide);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Star(String n) {
        this.decide = n;
    }

    private void printStar(int rowNumber, String n) throws InterruptedException{
        synchronized(this) {
            for (int i = 1; i <= rowNumber; i++) {
                if (n == "Spaces") {
                    //Print spaces
                    for (int j = 0; j < (9 - i); j++) {
                        System.out.print(" ");
                    }
                    notify();wait();
                }
                if (n == "Stars") {
                    //Print stars
                    for (int j = 0; j < (2 * i - 1); j++) {
                        System.out.print("*");
                    }
                    notify();wait();
                }
                System.out.println();
            }
        }
    }
}
