package com.bycsmys.character11;

import java.util.concurrent.*;

/**
 * @Author wangqd
 * @DATE 2020-03-16
 */
public class FutureTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Boolean> future = executor.submit(() -> delaySecond(1));
        try {
            //doSomeThing
            System.out.println("doSomeThing");

            Boolean flag = future.get(2, TimeUnit.SECONDS);
            System.out.println(flag);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("InterruptedException");
        } catch (ExecutionException e) {
            e.printStackTrace();
            System.out.println("ExecutionException");
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("TimeoutException");
        }
        executor.shutdown();
    }


    private static boolean delaySecond(long delaySecond){
        try {
            Thread.sleep(delaySecond * 1_000);
            return true;
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        return false;
    }
}
