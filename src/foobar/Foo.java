package foobar;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Foo implements Runnable{

    private int n;
    Semaphore f_s;
    Semaphore b_s;

    Foo(int n, Semaphore f_s,Semaphore b_s){

        this.n=n;
        this.f_s=f_s;
        this.b_s=b_s;
    }

    public void run(){
        for (int i=0;i<n;i++)
            try {
                f_s.acquire();
            }
        catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println("foo ,printed by "+Thread.currentThread());

        b_s.release();
    }
}
