package cn.itcast.thread;

import java.util.Date;

public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i =0;i<10;i++){
            System.out.println("myThread执行了："+new Date().getTime());
        }
    }
}
