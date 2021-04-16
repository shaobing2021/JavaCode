package juc2communication;

public class ABA {
    public static void main(String[] args) throws ClassNotFoundException {
        Data data = new Data();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                data.increment();
            }
        },"a").start();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                data.decrement();
            }
        },"b").start();

    }
}
class Data{
    private int count  = 0;
    public synchronized void increment(){
        while (count!=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println(Thread.currentThread().getName()+"===>"+count);
        this.notify();
    }
    public synchronized void decrement(){
        while (count==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName()+"===>"+count);
        this.notify();
    }
}
