package com.cyh.sync.method;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author CYH
 * @date 2018/07/12
 *
 * 两个线程访问两个对象的同一个同步方法
 *
 * 虽然对象的方法上加有 Synchronized 关键字，但是由于是多个对象，所以，不起作用
 */
public class MultiThreadSynchronizedOnMultiObject {

    public static void main(String[] args) {
        MyThread myThreadA = new MyThread(new MyObject());
        myThreadA.setName("A");
        myThreadA.start();
        MyThread myThreadB = new MyThread(new MyObject());
        myThreadB.setName("B");
        myThreadB.start();
    }

    static class MyThread extends Thread {
        private MyObject myObject;

        public MyThread(MyObject myObject) {
            this.myObject = myObject;
        }

        @Override
        public void run() {
            myObject.test();
        }
    }

    static class MyObject {

        synchronized void test() {
            System.out.println(Thread.currentThread().getName() + " -begin- " + new Date());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " -end- " + new Date());
        }

    }
}
