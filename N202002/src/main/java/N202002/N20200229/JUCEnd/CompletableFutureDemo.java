package N202002.N20200229.JUCEnd;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Joah
 * @time 2020/2/29 12:18
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 没有返回，update mysql ok");
        });
        voidCompletableFuture.get();

        // 异步回调
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 有返回 insert mysql ok");
            // int agt = 12 / 0;
            return 1024;
        });
        integerCompletableFuture.whenComplete((t, u) -> {
            System.out.println("*****t:" + t);
            System.out.println("*****u:" + u);
        }).exceptionally(f -> {
            System.out.println("******exception:" + f.getMessage());
            return 4444;
        }).get();

    }
}
