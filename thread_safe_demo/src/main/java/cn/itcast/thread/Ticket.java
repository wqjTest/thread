package cn.itcast.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {

    private int ticketNum = 100;//电影票数量，默认100张

    private Object obj = new Object();

    //参数是否是公平锁：true公平锁 ,多个线程公平拥有执行权；false非公平锁,独占锁。
    private Lock lock = new ReentrantLock(true);

    //1.同步代码块
    /*public void run() {
        while (true) {
            synchronized (obj) {
                if (ticketNum > 0) {//判断是否有票，ticketNum>0
                    //有票，让线程睡眠100毫秒
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //打印当前售出的票数字和线程名，票数减一
                    String name = Thread.currentThread().getName();
                    System.out.println("线程：" + name + "销售电影票：" + ticketNum--);
                }
            }
        }
    }*/

    //2.同步方法
    /*public void run() {
        while (true) {
            safeTicket();
        }
    }

    private synchronized void safeTicket() {
        if (ticketNum > 0) {//判断是否有票，ticketNum>0
            //有票，让线程睡眠100毫秒
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //打印当前售出的票数字和线程名，票数减一
            String name = Thread.currentThread().getName();
            System.out.println("线程：" + name + "销售电影票：" + ticketNum--);
        }
    }*/

    //3.同步锁
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (ticketNum > 0) {//判断是否有票，ticketNum>0
                    //有票，让线程睡眠100毫秒
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //打印当前售出的票数字和线程名，票数减一
                    String name = Thread.currentThread().getName();
                    System.out.println("线程：" + name + "销售电影票：" + ticketNum--);
                }
            } finally {
                lock.unlock();
            }

        }
    }
}
