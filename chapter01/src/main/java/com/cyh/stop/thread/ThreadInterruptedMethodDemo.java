package com.cyh.stop.thread;

/**
 * @author CYH
 * @date 2018/07/11
 *
 * Thread.interrupted()：测试当前线程是否已经中断，当前线程是指调用静态的 interrupted() 方法的线程
 */
public class ThreadInterruptedMethodDemo {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.interrupt();

        // 当前线程是 main 线程，它并未被中断，所以打印结果是False
        System.out.println("Interrupted: " + Thread.interrupted());
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int x = 0; x < 500000; x++) {
                System.out.println(x);
            }
        }
    }

}
