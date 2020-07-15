package cn.itcast.thread;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreeThreadStartDemo {
    //参数是参与CyclicBarrier的线程数
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    public void startThread(){
        //1.打印线程准备启动
        String name = Thread.currentThread().getName();
        System.out.println(name+"正在准备。。。");
        //2.调用cyclicBarrier的await方法等待线程全部准备完成
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        //3.打印线程启动完毕信息
        System.out.println(name+"已经启动完毕"+new Date().getTime());
    }

    public static void main(String[] args) {
        final  ThreeThreadStartDemo demo = new ThreeThreadStartDemo();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                demo.startThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                demo.startThread();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                demo.startThread();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
