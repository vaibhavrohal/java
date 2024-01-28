package OddEvenNumberByTwoThreads;

import java.util.concurrent.Semaphore;

public class Odd implements Runnable{
    private Semaphore zero;
    private Semaphore odd;
    private Semaphore even;
    private Count count;
    private int number;

    public Odd(Semaphore zero, Semaphore odd, Semaphore even, Count count, int number) {
        this.zero = zero;
        this.odd = odd;
        this.even = even;
        this.count = count;
        this.number = number;
    }

    @Override
    public void run() {
        try{
            for (int i=1;i<=number;i=i+2) {
                odd.acquire();

                System.out.println(i+ " " + Thread.currentThread());
                count.value++;
                zero.release();
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
