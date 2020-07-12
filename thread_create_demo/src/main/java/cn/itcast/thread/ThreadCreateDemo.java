package cn.itcast.thread;

import java.util.Date;
import java.util.concurrent.*;

public class ThreadCreateDemo {
    public static void main(String[] args) {
        /*******************************1.继承Thread*************************************************/
       /* //1.创建自定义线程实列
        MyThread myThread = new MyThread();
        //2.启动线程
        myThread.start();
        //3.在main主线程打印信息
        for (int i=0;i<10;i++){
            System.out.println("main主线程执行了："+new Date().getTime());
        }*/

        /*******************************2.实现Runnable*************************************************/
        /*//2.1在main主线程打印信息
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"执行时间："+new Date().getTime()+";执行次数是："+i);
        }
        //2.2通过thread类执行MyRunnable
        Thread thread = new Thread(new MyRunnable(),"MyRunnable");
        thread.start();*/

        /*******************************3.实现Callable*************************************************/
       /* //3.1创建FutureTask实列，执行MyCallable
        FutureTask<String> task = new FutureTask<String>(new MyCallable());
        //3.2创建Thread实列，执行FutureTask
        Thread thread = new Thread(task,"MyCallable");
        thread.start();
        //3.3在主线程打印信息
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"执行时间："+new Date().getTime()+";执行次数是："+i);
        }
        //3.4获取并打印MyCallable执行结果
        try {
           String result= task.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        /*******************************4.线程池*************************************************/
        //4.1使用Executors获取线程池对象
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //4.2通过线程池对象获取线程并执行MyRunnable实列
        executorService.execute(new MyRunnable());
        //4.3主线程打印信息
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"执行时间："+new Date().getTime()+";执行次数是："+i);
        }
    }
}
