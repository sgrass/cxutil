package org.cx.thread;

import java.util.concurrent.*;

/**
 * 当提交一个新任务到线程池时，线程池的处理流程
 * 1.判断线程是不是为空，如果是空的话，就抛出空指针异常
 * 2.如果线程池的数量小于核心线程池的个数，创建新的线程执行任务
 * 3.如果线程的数量大于核心线程的数量，就将线程放到缓存队列中
 * 4.如果任务队列满了，但还没有到达maximumPoolSize，则继续创建线程执行任务，如果线程数大于maximumPoolSize，则调用reject策略处理该任务
 *
 * 拒绝策略   自定义策略实现接口 {@link RejectedExecutionHandler}
 * ThreadPoolExecutor.AbortPolicy：线程池中的数量等于最大线程数时、直接抛出RejectedExecutionException
 * ThreadPoolExecutor.CallerRunsPolicy：重试执行当前的任务，交由调用者线程来执行任务
 * ThreadPoolExecutor.DiscardOldestPolicy：抛弃线程池中最后一个要执行的任务，并执行新传入的任务
 * ThreadPoolExecutor.DiscardPolicy：直接抛弃
 *
 *
 *
 * 线程池监控参数
 * getTaskCount：线程池已经执行的和未执行的任务总数
 * getCompletedTaskCount：线程池已完成的任务数量，该值小于等于taskCount
 * getLargestPoolSize：线程池曾经创建过的最大线程数量。通过这个数据可以知道线程池是否满过，也就是达到了maximumPoolSize
 * getPoolSize：线程池当前的线程数量
 * getActiveCount：当前线程池中正在执行任务的线程数量
 *
 * @author grass
 * @date 2017/6/2
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.printf("%s-->%d",Thread.currentThread().getName(), System.currentTimeMillis());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        int corePoolSize = 7;
        int maximumPoolSize = 8;
        int keepAliveTime = 5;
        TimeUnit unit = TimeUnit.SECONDS;
        LinkedBlockingDeque<Runnable> workQueue = new LinkedBlockingDeque<>();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);


        executor.execute(runnable);
    }
}
