package org.cx.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * java线程既是工作单元，也是执行机制，从jdk1.5开始，把工作单元与执行机制分离开。
 * 工作单元包括Runnabe和Callable，而执行机制由Executor框架提供
 *
 * 两个方法向线程池提交任务
 *  execute()方法适用于没有返回值的任务
 *  submit()方法用于提交有返回值的任务，线程池会返回一个future类型的对象
 *
 *
 * Executors各个方法的弊端：
 * 1）newFixedThreadPool和newSingleThreadExecutor:
 *   主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至OOM。
 * 2）newCachedThreadPool和newScheduledThreadPool:
 *   主要问题是线程数最大数是Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至OOM。
 *
 *
 * ThreadPoolExecutor 参数 核心线程数，最大线程数，超时时间，保存queue，AbortPolicy拒绝策略直接抛异常(4种)
 *
 * Positive example 1：
 *     //org.apache.commons.lang3.concurrent.BasicThreadFactory
 *     ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
 *         new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
 *
 * Positive example 2：
 *     ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
 *         .setNameFormat("demo-pool-%d").build();
 *
 *     //Common Thread Pool
 *     ExecutorService pool = new ThreadPoolExecutor(5, 200,
 *         0L, TimeUnit.MILLISECONDS,
 *         new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
 *
 *     pool.execute(()-> System.out.println(Thread.currentThread().getName()));
 *     pool.shutdown();//gracefully shutdown
 *
 *
 * Positive example 3：
 *     <bean id="userThreadPool"
 *         class="org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor">
 *         <property name="corePoolSize" value="10" />
 *         <property name="maxPoolSize" value="100" />
 *         <property name="queueCapacity" value="2000" />
 *
 *     <property name="threadFactory" value= threadFactory />
 *         <property name="rejectedExecutionHandler">
 *             <ref local="rejectedExecutionHandler" />
 *         </property>
 *     </bean>
 *     //in code
 *     userThreadPool.execute(thread);
 *
 *
 * @author grass
 * @date 2017/11/15
 */
public class ExecutorDemo {
    public static void main(String[] args) {
        //执行器，线程池（ThreadPoolExecutor）是它的一种实现
        Executor executor = Executors.newFixedThreadPool(1);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world ".concat(Thread.currentThread().getName()));
            }
        });

        //合理关闭线程池
        if (executor instanceof ExecutorService) {
            ExecutorService executorService = ExecutorService.class.cast(executor);
            executorService.shutdown();
        }


    }
}
