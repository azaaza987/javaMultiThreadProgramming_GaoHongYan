package com.cyh.sync.code.block;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author CYH
 * @date 2018/07/12
 *
 * 同步代码块，使用同一个对象锁
 */
public class SynchronizedBlockOnTheSameObject {

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
            myObject.methodA();
        }
    }

    static class MyThreadB extends Thread {
        private MyObject myObject;

        public MyThreadB(MyObject myObject) {
            this.myObject = myObject;
        }

        @Override
        public void run() {
            myObject.methodB();
        }
    }

    static class MyObject {
        public void methodA() {
            synchronized (this) {
                System.out.println("methodA() begin: " + new Date());
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("methodA() end: " + new Date());
            }
        }

        public void methodB() {
            synchronized (this) {
                System.out.println("methodB() begin: " + new Date());
                System.out.println("methodB() end: " + new Date());
            }
        }
    }
}
