package org.cx.thread.volatilee;

import java.util.concurrent.TimeUnit;

/**
 * 内存不可见原因
 *  缓存机制
 *  重排序机制
 * @author grass
 * @date 2017/10/29
 */
public class VisibilityDemo {

    private static boolean isStop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println("thread start");
            int i=0;
            while (!isStop) {
                try {
                    //没有volatile或者synchronize时也可以增加sleep这行，就不会死循环了
                    //sleep醒来的时候，会置本地内存失效，从主内存中去拿，所以线程会结束
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
            System.out.println("thread stop");
        });


        t1.start();

        TimeUnit.SECONDS.sleep(1);

        //主线程赋值true的操作 对于其他子线程不可见，isStop还是拿的本地的值，加volatile或者synchronize解决
        isStop = true;

        System.out.println(isStop);

    }
}

