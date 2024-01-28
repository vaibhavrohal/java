package producerconsumer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main (String [] args){
      Queue<Object> store=new ConcurrentLinkedQueue();

      int maxsize=4;

      Semaphore producersemaphore=new Semaphore (maxsize);
      Semaphore consumersemaphore=new Semaphore (0);

      Producer p1=new Producer (store,maxsize,"p1",producersemaphore,consumersemaphore);
      Producer p2=new Producer (store,maxsize,"p2",producersemaphore,consumersemaphore);
      Producer p3=new Producer (store,maxsize,"p3",producersemaphore,consumersemaphore);
      Thread t1=new Thread (p1);
      Thread t2=new Thread (p2);
      Thread t3=new Thread (p3);

      t1.start();
      t2.start();
      t3.start();

      Consumer c1=new Consumer (store,maxsize,"c1",producersemaphore,consumersemaphore);
        Consumer c2=new Consumer (store,maxsize,"c2",producersemaphore,consumersemaphore);
        Consumer c3=new Consumer (store,maxsize,"c3",producersemaphore,consumersemaphore);

        Thread t4=new Thread (c1);
        Thread t5=new Thread (c2);
        Thread t6=new Thread (c3);
        t4.start();
        t5.start();
        t6.start();



    }
}
