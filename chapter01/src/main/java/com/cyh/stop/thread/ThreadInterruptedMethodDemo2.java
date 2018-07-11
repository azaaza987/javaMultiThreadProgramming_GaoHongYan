package com.cyh.stop.thread;

/**
 * @author CYH
 * @date 2018/07/11
 *
 * 中断当前线程，并查看是否被中断
 */
public class ThreadInterruptedMethodDemo2 {

    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        // 当前线程已经被中断，所以打印True
        System.out.println("Interrupted: " + Thread.interrupted());
    }
}
