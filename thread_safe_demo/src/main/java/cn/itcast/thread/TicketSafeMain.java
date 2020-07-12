package cn.itcast.thread;

public class TicketSafeMain {
    public static void main(String[] args){
        //1.创建电影票对象
        Ticket ticket = new Ticket();
        //2.创建Thread对象，执行电影票售卖
        Thread thread1 = new Thread(ticket,"窗口1");
        Thread thread2= new Thread(ticket,"窗口2");
        Thread thread3 = new Thread(ticket,"窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
