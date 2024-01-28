package producerconsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private Queue<Object> store;
    private int maxsize;
    private String name;
    private Semaphore producersemaphore;
    private Semaphore consumersemaphore;

    Consumer (Queue <Object> store,int maxsize,String name,Semaphore producersemaphore,Semaphore consumersemaphore){
        this.store=store;
        this.maxsize=maxsize;
        this.name=name;
        this.producersemaphore=producersemaphore;
        this.consumersemaphore=consumersemaphore;
    }

    @Override
    public void run(){
        while(true) {
            try {
                consumersemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.name + " is consuming, size of store " + store.size());
            store.remove();
            producersemaphore.release();
        }

    }
}
