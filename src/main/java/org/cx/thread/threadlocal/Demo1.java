package org.cx.thread.threadlocal;

/**
 * @author grass
 * @date 2017/10/28
 */
public class Demo1 {

    private static int num = 0;

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(()->{
                num+=5;
                System.out.printf("%s --> %s \n", Thread.currentThread().getName(), num);
            }, "Thread Name-"+i);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
