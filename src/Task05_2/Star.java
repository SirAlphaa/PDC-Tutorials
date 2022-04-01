package Task05_2;

public class Star implements Runnable {

    int max = 8;

    @Override
    public void run(){
        for (int i = 1; i <= max; i++) {
            for (int j = 0; j < (9 - i); j++) {
                spaces();
            }
            for (int j = 0; j < (2 * i - 1); j++) {
                stars();
            }
        System.out.println(" ");
        }
        System.exit(0);
    }

    synchronized void spaces() {
        System.out.print(" ");
        notifyAll();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void stars(){
        System.out.print("*");
        notifyAll();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    // for (int i = 1; i <= rowNumber; i++) {
    //     //Print spaces
    //     for (int j = 0; j < (9 - i); j++) {
    //         System.out.print(" ");
    //     }
    //     //Print stars
    //     for (int j = 0; j < (2 * i - 1); j++) {
    //         System.out.print("*");
    //     }
    //     System.out.println();
    // }
}

