import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        Node A=new Node(1);
        A.left=new Node(2);
        A.right=new Node(3);
        A.left.left=new Node(4);

        ExecutorService executorService= Executors.newCachedThreadPool();
        TreeSizeCalculator treeSizeCalculator=new TreeSizeCalculator(A,executorService);
        System.out.println(treeSizeCalculator.call());
    }
}