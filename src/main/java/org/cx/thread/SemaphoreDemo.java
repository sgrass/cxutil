package org.cx.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量
 * @author grass
 * @date 2018/9/9
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i <10; i++) {
            new DoAnything(i, semaphore).start();
        }
    }

    static class DoAnything extends Thread {
        private int num;
        private Semaphore semaphore;

        public DoAnything(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                //获取一个令牌
                semaphore.acquire();

                System.out.println(Thread.currentThread().getName() + "线程进入");

                TimeUnit.SECONDS.sleep(2);

                //释放令牌
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + "线程释放");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
