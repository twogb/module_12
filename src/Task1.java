import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task1 {
    public static void main(String[] args) {

        Thread thread1 = new Thread(() ->
        {
            long startTime = System.currentTimeMillis();

            while (true) {
                System.out.println("Минуло " + (System.currentTimeMillis() - startTime) + " секунд");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() ->
        {
            while (true) {
                System.out.println("Минуло 5 секунд");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}

