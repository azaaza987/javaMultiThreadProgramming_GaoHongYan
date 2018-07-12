package com.cyh.sync.method;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author CYH
 * @date 2018/07/12
 *
 * 两个线程访问同一个对象的同一个同步方法
 *
 * 对象的方法上加有 Synchronized 关键字，所以，多线程是同步访问的
 */
public class MultiThreadSynchronizedOnTheSameObjectWithTheSameMethod {

    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        MyThread myThreadA = new MyThread(myObject);
        myThreadA.setName("A");
        myThreadA.start();
        MyThread myThreadB = new MyThread(myObject);
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
