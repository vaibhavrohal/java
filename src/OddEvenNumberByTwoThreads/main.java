package OddEvenNumberByTwoThreads;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class main {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        Semaphore o=new Semaphore(0);
        Semaphore e=new Semaphore(0);
        Semaphore zero=new Semaphore(1);
        Count c=new Count();

        Odd o1=new Odd(zero,o,e,c,n);
        Even e1=new Even(o,e,zero,c,n);
        Zero z1=new Zero(o,e,zero,n);

        Thread t1=new Thread(o1);
        Thread t2=new Thread(e1);
        Thread t3=new Thread(z1);

        t1.start();
        t2.start();
        t3.start();
    }
}
