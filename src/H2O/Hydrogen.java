package H2O;

import java.util.concurrent.Semaphore;

public class Hydrogen implements Runnable{
    private Semaphore o;
    private Semaphore h;

    public Hydrogen(Semaphore o, Semaphore h) {
        this.o = o;
        this.h = h;
    }

    @Override
    public void run() {
        try{
            h.acquire();
            for (int i=0;i<2;i++){
                System.out.println("H ,printed by "+Thread.currentThread());
            }
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
        o.release();
    }
}
