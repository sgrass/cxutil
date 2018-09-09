package org.cx.thread.volatilee;

import java.util.ArrayList;
import java.util.List;

/**
 * @author grass
 * @date 2017/10/29
 */
public class Demo1 {

    private long i = 0L;
//    private volatile long i = 0L;

    /**
     * volatile只保证单一操作原子性，而不保证复合操作原子性。所以就算对i加了volatile，多线程加加也还是不对
     */
    private void add() {
        /**
         * i++是复合操作,三步操作 javap如下
         * getstatic
         * iadd
         * putstatic
         */
        i++;
    }

    private long getI() {
        return i;
    }

    /**
     * as-if-serial
     *      所有的动作都可以为了优化而被重排序,但不管怎么重排序（单线程）程序的执行结果不会改变。
     *
     * area依赖pi和r，所以会排在后边，pi和r不一定谁优先
     *  pi Happen-before r
     *  r Happen-before c
     *  pi Happen c
     */
    public void test() {
        double pi = 3.14;
        double r = 1.0;
        double area = pi * r * r;
    }

    public static void main(String[] args) {
        final Demo1 demo1 = new Demo1();
        List<Thread> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    demo1.add();
                }
            });
            list.add(thread);
        }

        for (Thread thread : list) {
            thread.start();
        }

        for (Thread thread : list) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(demo1.getI());
    }
}
