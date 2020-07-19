package cn.itcast.thread;

import java.util.concurrent.Semaphore;

public class WorkerMachineDemo {
    static class Work implements Runnable {
        private int workerNum;//工人工号
        private Semaphore semaphore;//机器数

        public Work(int workerNum, Semaphore semaphore) {
            this.workerNum = workerNum;
            this.semaphore = semaphore;
        }

        public void run() {
            try {
                //1.工人要去获取机器
                semaphore.acquire();
                //2.打印工人获取到机器，开始工作
                String name = Thread.currentThread().getName();
                System.out.println(name + "获取到机器，开始工作。。。");
                //3.线程睡眠1000毫秒，模拟工人使用完毕，释放机器
                Thread.sleep(1000);
                //4.使用完毕，释放机器，打印工人使用完毕，释放机器
                semaphore.release();
                System.out.println(name + "使用完毕，释放机器。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            int workers = 8;//工人数8个
            Semaphore semaphore = new Semaphore(3);//机器数3个
            for (int i = 0; i < workers; i++) {
                new Thread(new Work(i, semaphore)).start();
            }
        }
    }
}
