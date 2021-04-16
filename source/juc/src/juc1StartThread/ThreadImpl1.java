package juc1StartThread;

/**
 * runable实现
 */
public class ThreadImpl1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("run:"+i);
        }
    }

    public static void main(String[] args) {
        ThreadImpl1 threadImpl1 = new ThreadImpl1();
        new Thread(threadImpl1).start();
        for (int i = 0; i < 200; i++) {
            System.out.println("main:"+i);
        }

    }
}
