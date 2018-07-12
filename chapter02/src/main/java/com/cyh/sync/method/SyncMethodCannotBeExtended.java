package com.cyh.sync.method;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author CYH
 * @date 2018/07/12
 *
 * 同步方法不能被继续
 */
public class SyncMethodCannotBeExtended {


    public static void main(String[] args) {
        Sub sub = new Sub();
        MyThread myThread = new MyThread(sub);
        myThread.setName("A");
        myThread.start();

        MyThread myThreadB = new MyThread(sub);
        myThreadB.setName("B");
        myThreadB.start();
    }

    static class MyThread extends Thread {
        private Sub sub;

        public MyThread(Sub sub) {
            this.sub = sub;
        }

        @Override
        public void run() {
            this.sub.serviceMethod();
        }
    }

    static class Main {
        /**
         * 提示：方法被 Synchronized 关键字修饰
         */
        synchronized void serviceMethod() {
            System.out.println("Main " + Thread.currentThread().getName() + " -begin- " + new Date());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Main " + Thread.currentThread().getName() + " -end- " + new Date());
        }
    }

    static class Sub extends Main {
        /**
         * 提示：方法 没有 没有 没有 没有 被 Synchronized 关键字修饰
         */
        @Override
        void serviceMethod() {
            System.out.println("Sub " + Thread.currentThread().getName() + " -begin- " + new Date());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sub " + Thread.currentThread().getName() + " -end- " + new Date());
            super.serviceMethod();
        }
    }

}
