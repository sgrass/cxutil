package org.cx.thread;

import java.util.Map;
import java.util.concurrent.*;

/**
 * CyclicBarrier字面意思 cyclic(可循环使用的) barrier(屏障)
 * 让一组线程到达一个屏障时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被阻塞的线程才会继续运行。
 * 每个线程调用await()方法告诉CyclicBarrier已经到达屏障
 *
 * 对比
 * CountdownLatch计数器只能使用一次。
 * CyclicBarrier可以通过reset()方法重置计数器，还有getNumberWaiting()方法获得阻塞线程数。isBroken()方法获取线程是否阻塞
 */
public class CyclicBarrierTest implements Runnable {

    public static final int count=10;

    private CyclicBarrier c = new CyclicBarrier(count, this);

    private Executor executor = Executors.newFixedThreadPool(count);

    private ConcurrentHashMap<String, Integer> sheetWaterCount = new ConcurrentHashMap<>();


    private void count() {
        for (int i = 0; i < count ; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    sheetWaterCount.put(Thread.currentThread().getName(), 1);
                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }


    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String, Integer> sheet : sheetWaterCount.entrySet()) {
            result += sheet.getValue();
            System.out.println(sheet.getKey()+"---"+sheet.getValue());
        }
        sheetWaterCount.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        CyclicBarrierTest cyclic = new CyclicBarrierTest();
        cyclic.count();


    }
}
