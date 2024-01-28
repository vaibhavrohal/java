package foobar;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.Queue;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static  void main(String[] args) {
       Queue<Object> print=new ConcurrentLinkedQueue<>();

       Semaphore f_s=new Semaphore(2);
       Semaphore b_s=new Semaphore(0);

        int n=1;
        Foo f=new Foo(n,f_s,b_s);
        Bar b=new Bar(n,f_s,b_s);

        Thread t_foo=new Thread(f);
        Thread b_bar=new Thread(b);

        t_foo.start();
        b_bar.start();
    }
}