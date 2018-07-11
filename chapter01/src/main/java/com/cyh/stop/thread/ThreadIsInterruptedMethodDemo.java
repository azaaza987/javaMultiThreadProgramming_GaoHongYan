package com.cyh.stop.thread;

/**
 * @author CYH
 * @date 2018/07/11
 *
 * 实例的 isInterrupted() 方法，判断实例线程是否被中断
 */
public class ThreadIsInterruptedMethodDemo {


    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.interrupt();
        // myThread 线程已经被中断，所以打印True
        System.out.println("Is Interrupted: " + myThread.isInterrupted());
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
