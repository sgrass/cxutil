package org.cx.thread.volatilee;

import java.util.concurrent.TimeUnit;

/**
 * @author grass
 * @date 2017/10/29
 */
public class ObjVisibilityDemo {

    private static TestObj testObj = new TestObj();

    private static TestObj obj2 = null;


    /**
     * 死循环
     * @throws InterruptedException
     */
    public static void test1() throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println("thread start");
            int i=0;
            while (testObj != null) {
                i++;
            }
            System.out.println("thread stop");
        });


        t1.start();

        TimeUnit.SECONDS.sleep(1);

        testObj = null;

        System.out.println(testObj);
    }


    /**
     * 不会死循环
     * happens-before-order  第一次new TestObj()对象的时候能够被所有的线程观察到,只有第一次有用
     * @throws InterruptedException
     */
    public static void test2() throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println("thread start");
            int i=0;
            while (testObj == null) {
                i++;
            }
            System.out.println("thread stop");
        });


        t1.start();

        TimeUnit.SECONDS.sleep(1);

        testObj = new TestObj();

        System.out.println(testObj);
    }
    public static void main(String[] args) throws InterruptedException {
//        test1();
        test2();

    }

    static class TestObj {

    }
}
