package juc1StartThread;

/**
 * 继承thread类
 */
public class ThreadImpl extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("run:"+i);
        }
    }

    public static void main(String[] args) {
        ThreadImpl thread = new ThreadImpl();
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main:"+i);
        }
    }
}
