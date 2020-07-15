package cn.itcast.thread;

import java.util.concurrent.CountDownLatch;

public class CoachRacerDemo {
    private CountDownLatch countDownLatch = new CountDownLatch(3);//设置要等待的运动员是3个

    /**
     * 运动员方法，由运动员线程调用
     */
    public void racer()   {
        //1.获取运动员线程名称
        String name =Thread.currentThread().getName();
        //2.运动员开始准备：打印准备信息
        System.out.println(name+"正在准备。。。");
        //3.线程睡醒1000毫秒，表示运动员在准备
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //4.运动员准备完毕：打印准备完毕信息
        System.out.println(name+"准备完毕！");
        //同事计数减一
        countDownLatch.countDown();
    }

    /**
     * 教练方法，由教练线程调用
     */
    public void coach()   {
        //1.获取教练线程名称
        String name =Thread.currentThread().getName();
        //2.运动员开始准备：打印准备信息
        System.out.println(name+"等待运动员准备。。。");
        //3.调用countDownLatch的await方法等待其他线程执行完毕
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //4.所有运动员准备完毕,教练开始训练，打印训练信息
        System.out.println("所有运动员就绪"+name+"开始训练！");
    }

    public static void main(String[] args) {
        //1.创建CoachRacerDemo实列
        final  CoachRacerDemo coachRacerDemo = new CoachRacerDemo();
        //2.创建三个线程对象，调用CoachRacerDemo的racer方法
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                coachRacerDemo.racer();
            }
        } ,"运动员1");
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                coachRacerDemo.racer();
            }
        } ,"运动员2");
        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                coachRacerDemo.racer();
            }
        } ,"运动员3");
        //2.创建一个线程对象，调用CoachRacerDemo的coach方法
        Thread thread4 = new Thread(new Runnable() {
            public void run() {
                coachRacerDemo.coach();
            }
        } ,"教练");

        thread4.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
