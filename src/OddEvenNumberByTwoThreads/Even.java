package OddEvenNumberByTwoThreads;

import java.util.concurrent.Semaphore;

public class Even implements Runnable{
    private Semaphore odd;
    private Semaphore even;
    private Semaphore zero;
    private Count count;
    private int number;

    public Even(Semaphore odd, Semaphore even, Semaphore zero, Count count, int number) {
        this.odd = odd;
        this.even = even;
        this.zero = zero;
        this.count = count;
        this.number = number;
    }

    @Override
    public void run() {
        try{
            for (int i=2;i<=number;i=i+2) {
                even.acquire();
                System.out.println(i + " " + Thread.currentThread());

                zero.release();
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
