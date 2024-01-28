package H2O;

import java.util.concurrent.Semaphore;

public class Oxygen implements Runnable{
    private Semaphore o;
    private Semaphore h;

    public Oxygen(Semaphore o, Semaphore h) {
        this.o = o;
        this.h = h;
    }

    @Override
    public void run() {
        try{
            o.acquire();
            System.out.println("O");
            h.release();
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
