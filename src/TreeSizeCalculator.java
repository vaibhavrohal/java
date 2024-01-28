import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable <Integer> {
    private Node root;
   private  ExecutorService executorService;


    public TreeSizeCalculator(Node root,ExecutorService executorService) {
        this.root = root;
        this.executorService = executorService;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("thread name "+ Thread.currentThread().getName());
         if (root==null) return 0;

         TreeSizeCalculator treeSizeCalculator1=new TreeSizeCalculator(root.left,executorService);
         //int a= treeSizeCalculator1.call();
        Future<Integer> aFuture=executorService.submit(treeSizeCalculator1);

         TreeSizeCalculator treeSizeCalculator2=new TreeSizeCalculator(root.right,executorService);
         //int b=treeSizeCalculator2.call();
        Future<Integer> bFuture=executorService.submit(treeSizeCalculator2);

        int a=aFuture.get();
        int b=bFuture.get();

        return Math.max(a,b)+1;
    }
}
