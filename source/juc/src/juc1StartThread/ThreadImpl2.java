package juc1StartThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadImpl2 {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                for (int i = 0; i < 100; i++) {
                    System.out.println("call:"+i);
                }
                return 100;
            }
        });

        new Thread(futureTask).start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main:"+i);
        }

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
