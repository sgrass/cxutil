package org.cx.thread.volatilee;

import java.util.concurrent.TimeUnit;

/**
 * volatile的实现原理
 *  参考https://tech.meituan.com/java-memory-reordering.html
 *
 * @author grass
 * @date 2017/10/29
 */
public class VisibilityDemo2 {
    //线程b修改对线程a不可见，i增加volatile关键字即可,volatile关键字会让a线程本地变量失效直接去主内存同步
    public static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        B b = new B();

        a.start();
        TimeUnit.SECONDS.sleep(1);
        b.start();

    }

    static class A extends Thread {
        @Override
        public void run() {
            while (true) {
                if (i == 1) {
                    System.out.println("A");
                    break;
                }
            }
        }
    }

    static class B extends Thread {
        @Override
        public void run() {
            i++;
            System.out.println("B");
        }
    }

}
