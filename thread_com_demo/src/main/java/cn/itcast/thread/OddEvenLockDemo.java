package cn.itcast.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenLockDemo {

    private int i = 0; //要打印的数
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     * 奇数打印方法，由奇数线程调用
     */
    public void odd() {
        //1.判断i是否小于10
        while (i < 10) {
            lock.lock();
            try {
                //2.<10打印奇数
                if (i % 2 == 1) {
                    System.out.println("奇数" + i);
                    i++;
                    condition.signal();//唤醒等待线程
                } else {
                    try {
                        condition.await();//等待偶数线程打印
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }

        }
    }

    /**
     * 偶数打印方法，由偶数线程调用
     */
    public void even() {
        //1.判断i是否小于10
        while (i < 10) {
            lock.lock();
            try {
                //2.<10打印偶数
                if (i % 2 == 0) {
                    System.out.println("偶数" + i);
                    i++;
                    condition.signal();//唤醒等待线程
                } else {
                    try {
                        condition.await();//等待偶数线程打印
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        final OddEvenLockDemo oddEvenDemo = new OddEvenLockDemo();
        //1.启动奇数线程
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                oddEvenDemo.odd();
            }
        });
        //2.启动偶数线程
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                oddEvenDemo.even();
            }
        });

        thread1.start();
        thread2.start();
    }


}
