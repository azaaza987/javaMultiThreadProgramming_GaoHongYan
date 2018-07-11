package com.cyh.stop.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author CYH
 * @date 2018/07/11
 *
 * 可以响应中断的线程
 * 使用了 Thread#isInterrupted() 方法来判断是否被中断，然后做出相应处理
 */
public class ResponseInterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        TimeUnit.SECONDS.sleep(1);
        myThread.interrupt();
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                for (int x = 0; x < 500000; x++) {
                    if (isInterrupted()) {
                        throw new InterruptedException();
                    }
                    System.out.println(x);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
