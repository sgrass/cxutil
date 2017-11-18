package org.cx.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
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
