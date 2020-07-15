package cn.itcast.thread;

public class OddEvenDemo {

    private int i = 0; //要打印的数
    private Object obj = new Object();

    /**
     * 奇数打印方法，由奇数线程调用
     */
    public void odd() {
        //1.判断i是否小于10
        while (i < 10) {
            //2.<10打印奇数
            if (i % 2 == 1) {
                System.out.println("奇数" + i);
                i++;
                obj.notify();//唤醒等待线程
            } else {
                try {
                    obj.wait();//等待偶数线程打印
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
