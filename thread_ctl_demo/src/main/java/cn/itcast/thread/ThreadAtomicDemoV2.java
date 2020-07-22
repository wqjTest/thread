package cn.itcast.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadAtomicDemoV2 {
//    static private int n;//执行n++操作的变量
      static AtomicInteger atomicInteger;

    public static void main(String[] args) throws InterruptedException {
        int j = 0;
        while (j<100){
//            n=0;
            atomicInteger = new AtomicInteger(0);//创建原子整数，初始值0
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<1000;i++){
//                        n++;
                        atomicInteger.getAndIncrement();//对应n++操作
                    }
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<1000;i++){
                        atomicInteger.getAndIncrement();//对应n++操作
                    }
                }
            });

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            j++;
            System.out.println("n的最终值："+atomicInteger.get());
        }

    }
}
