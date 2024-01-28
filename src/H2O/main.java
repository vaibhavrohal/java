package H2O;

import java.util.concurrent.Semaphore;

public class main {
    public static void main(String [] args){
        Semaphore h=new Semaphore(1);
        Semaphore o=new Semaphore(0);

        Hydrogen h1=new Hydrogen(o,h);
        Oxygen o1=new Oxygen(o,h);

        Thread t1=new Thread(h1);
        Thread t2=new Thread(o1);

        t1.start();
        t2.start();
    }
}
