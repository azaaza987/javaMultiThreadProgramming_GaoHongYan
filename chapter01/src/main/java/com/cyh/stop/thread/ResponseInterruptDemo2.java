package com.cyh.stop.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author CYH
 * @date 2018/07/11
 *
 * 可以响应中断的线程
 * 使用了 Thread#sleep() 方法来判断是否被中断，然后做出相应处理
 * Thread#sleep() 方法响应中断后，会吃掉这个中断标志（状态）
 */
public class ResponseInterruptDemo2 {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        TimeUnit.SECONDS.sleep(2);
        myThread.interrupt();
        // Thread#sleep() 方法响应中断后，会吃掉这个中断标志（状态）
        System.out.println("Is Interrupted: " + myThread.isInterrupted());
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("run() begin");
                Thread.sleep(20000);
                System.out.println("run() end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
