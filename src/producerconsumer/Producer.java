package producerconsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Queue<Object> store;
    private int maxsize;
    private String name;
    private Semaphore producersemaphore;
    private Semaphore consumersemaphore;
    Producer (Queue<Object> store,int maxsize,String name,Semaphore producersemaphore,Semaphore consumersemaphore){
        this.store=store;
        this.maxsize=maxsize;
        this.name=name;
        this.producersemaphore=producersemaphore;
        this.consumersemaphore=consumersemaphore;
    }

    @Override
    public void run(){
        while (true) {
            try {
                producersemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.name + " is producing, size= " + store.size());
            store.add(new Object());
            consumersemaphore.release();
        }
    }
}
