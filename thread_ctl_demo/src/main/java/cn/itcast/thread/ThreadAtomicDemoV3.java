package cn.itcast.thread;

import java.util.concurrent.atomic.AtomicStampedReference;

public class ThreadAtomicDemoV3 {
      static AtomicStampedReference<Integer> atomicInteger;

    public static void main(String[] args) throws InterruptedException {
        int j = 0;
        while (j<100){
//            n=0;
            atomicInteger = new AtomicStampedReference<>(0,0);//创建原子整数，初始值0
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<1000;i++){
//                        n++;
                        int stamp;
                        Integer reference;
                        do {
                            stamp = atomicInteger.getStamp();
                            reference = atomicInteger.getReference();
                        }while (!atomicInteger.compareAndSet(reference,reference+1,stamp,stamp+1));
                    }
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<1000;i++){
                        int stamp;
                        Integer reference;
                        do {
                            stamp = atomicInteger.getStamp();
                            reference = atomicInteger.getReference();
                        }while (!atomicInteger.compareAndSet(reference,reference+1,stamp,stamp+1));
                    }
                }
            });

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            j++;
            System.out.println("n的最终值："+atomicInteger.getReference());
        }

    }
}
