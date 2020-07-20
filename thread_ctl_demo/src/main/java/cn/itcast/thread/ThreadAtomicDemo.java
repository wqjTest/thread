package cn.itcast.thread;

public class ThreadAtomicDemo {
    static private int n;//执行n++操作的变量

    public static void main(String[] args) throws InterruptedException {
        int j = 0;
        while (j<100){
            n=0;
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<1000;i++){
                        n++;
                    }
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<1000;i++){
                        n++;
                    }
                }
            });

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            j++;
            System.out.println("n的最终值："+n);
        }

    }
}
