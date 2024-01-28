package OddEvenNumberByTwoThreads;

import java.util.concurrent.Semaphore;

public class Zero implements Runnable{
    private Semaphore odd;
    private Semaphore even;
    private  Semaphore zero;

    private int number;

    public Zero(Semaphore odd, Semaphore even, Semaphore zero, int number) {
        this.odd = odd;
        this.even = even;
        this.zero = zero;
        this.number = number;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= number; i++) {
                zero.acquire();
                System.out.print("0");
                if (i%2!=0)odd.release();
                else even.release();
            }
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
