package cn.itcast.thread;

public class DeadLockDemo {
    public static void main(String[] args) {
        //创建两个DeadLockRunnable实列：flag=1;flag=2;
        DeadLockRunnable runnable1 = new DeadLockRunnable(1);
        DeadLockRunnable runnable2 = new DeadLockRunnable(2);
        //2.创建两个线程执行两个DeadLockRunnable实列
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
    }
}
