package com.cyh.stop.thread;

/**
 * @author CYH
 * @date 2018/07/11
 *
 * 不能被中断的线程
 */
public class CannotStoppedThreadDemo {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        // run() 方法中没有响应中断的逻辑，所以，不能中断
        myThread.interrupt();
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
