package com.github.leetcodeapp.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: douruanliang
 * @date: 2020/8/2
 */
class Thread_test {


    public static void main(String[] args) {
        executor();
    }

    static void executor() {
        ExecutorService executors = Executors.newSingleThreadExecutor();
        executors.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("i am runnable");
            }
        });
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1_000);
                return "callable";
            }
        };
        Future<String> future = executors.submit(callable);
        try {
            System.out.println("future " + future.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
