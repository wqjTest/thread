package cn.itcast.thread;

import java.util.Date;

/**
 * 自定义类实现Runnable接口
 */
public class MyRunnable implements Runnable{
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"执行时间："+new Date().getTime()+";执行次数是："+i);
        }
    }
}
