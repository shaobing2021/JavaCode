package juc2communication;

public class SynWaitNotify {
    private int loopNumebr;
    private int flag;
    public SynWaitNotify(int flag,int loopNumebr){
        this.loopNumebr = loopNumebr;
        this.flag = flag;
    }
    public static void main(String[] args) {
        SynWaitNotify synWaitNotify = new SynWaitNotify(1,5);
        new Thread(()->{
            synWaitNotify.print(1,2,"a");
        }).start();
        new Thread(()->{
            synWaitNotify.print(2,1,"b");
        }).start();
    }
    private void print(int waitFlag,int nextFlag,String str){
        for (int i = 0; i < loopNumebr; i++) {
            synchronized (this){
                while (flag!=waitFlag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(str);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }
}
