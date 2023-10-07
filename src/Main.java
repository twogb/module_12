

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Главный поток " + i);
        }
        Thread thread1 = new Thread(()->
        {
            for (int i = 0; i < 5; i++) {
                System.out.println("Поток1 " + i);
            }
        });
        Thread thread2 = new Thread(()->
        {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException interruptedException)
            {
                interruptedException.printStackTrace();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("Поток2 " + i);
            }
        });
        thread1.start();
        thread2.start();
    }
}

