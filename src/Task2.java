import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Task2 {
    private int n;
    private BlockingQueue<String> queue;
    private int current;

    public Task2(int n) {
        this.n = n;
        this.queue = new LinkedBlockingQueue<>();
        this.current = 1;
    }

    public void fizz() throws InterruptedException {
        while (current <= n) {
            synchronized (queue) {
                if (current % 3 == 0 && current % 5 != 0) {
                    queue.put("fizz");
                    current++;
                }
            }
        }
    }

    public void buzz() throws InterruptedException {
        while (current <= n) {
            synchronized (queue) {
                if (current % 5 == 0 && current % 3 != 0) {
                    queue.put("buzz");
                    current++;
                }
            }
        }
    }

    public void fizzbuzz() throws InterruptedException {
        while (current <= n) {
            synchronized (queue) {
                if (current % 15 == 0) {
                    queue.put("fizzbuzz");
                    current++;
                }
            }
        }
    }

    public void number() throws InterruptedException {
        while (current <= n) {
            synchronized (queue) {
                if (current % 3 == 0 && current % 5 == 0) {
                    queue.put("fizzbuzz");
                } else if (current % 3 == 0) {

                    queue.put("fizz");
                } else if (current % 5 == 0) {
                    queue.put("buzz");
                } else {
                    queue.put(Integer.toString(current));
                }
                current++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 15;
        Task2 fizzBuzz = new Task2(n);

        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        threadA.join();
        threadB.join();
        threadC.join();
        threadD.join();

        while (!fizzBuzz.queue.isEmpty()) {
            System.out.print(fizzBuzz.queue.take() + " ");
        }
    }
}




