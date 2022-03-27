package Task05_1;

public class Counter implements Runnable {

    int num;

    @Override
    public void run() {
        for (int j = this.num; j <= 10; j += 2) {
            if (num == 0) {
                System.out.println("Thread " + num + ": " + j);
            }
            if (num == 1) {
                System.out.println("Thread " + num + ":    " + j);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Counter(int i) {
        this.num = i;
    }
}
