package com.cyh.sync.method;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author CYH
 * @date 2018/07/12
 *
 * 两个线程访问同一个对象的两个同步方法
 *
 * 对象的不同方法上加有 Synchronized 关键字，多线程调用不同的方法时，还是会同步
 * 因为 Synchronized 修饰普通方法时，拿的是实例对象锁
 */
public class MultiThreadSynchronizedOnTheSameObjectWithDifferentMethod {

    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        MyThreadA myThreadA = new MyThreadA(myObject);
        myThreadA.setName("A");
        myThreadA.start();
        MyThreadB myThreadB = new MyThreadB(myObject);
        myThreadB.setName("B");
        myThreadB.start();
    }

    static class MyThreadA extends Thread {
        private MyObject myObject;

        public MyThreadA(MyObject myObject) {
            this.myObject = myObject;
        }

        @Override
        public void run() {
            myObject.testA();
        }
    }

    static class MyThreadB extends Thread {
        private MyObject myObject;

        public MyThreadB(MyObject myObject) {
            this.myObject = myObject;
        }

        @Override
        public void run() {
            myObject.testB();
        }
    }

    static class MyObject {

        synchronized void testA() {
            System.out.println(Thread.currentThread().getName() + " -begin- " + new Date());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " -end- " + new Date());
        }

        synchronized void testB() {
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
