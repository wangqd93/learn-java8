package com.bycsmys.character11;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author wangqd
 * @DATE 2020-03-23
 */
public class CompletableFutureTest {


    public static void main(String[] args) {
        CompletableFuture<Double> future = new CompletableFuture<>();

        new Thread(() -> {
            Random random = new Random();
            double i = random.nextDouble();
            future.complete(i);
        }
        ).start();


        try {
            Double d = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
