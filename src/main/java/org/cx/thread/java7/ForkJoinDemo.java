package org.cx.thread.java7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * @author grass
 * @date 2017/11/15
 */
public class ForkJoinDemo {
    public static void main(String[] args) {
        //并行:多核心参与
        //并发：一同参与

        //ForkJoinPool
        System.out.println("当前公用ForkJoin线程池 并行数-->" + ForkJoinPool.commonPool().getParallelism());
        System.out.println("当前cpu处理器数-->" + Runtime.getRuntime().availableProcessors());

        //与ThreadPoolExecutor类似
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        //forkjoinTask实现麻烦
//        forkJoinPool.invoke(new ForkJoinTask<String>() {
//            @Override
//            public String getRawResult() {
//                return null;
//            }
//
//            @Override
//            protected void setRawResult(String value) {
//
//            }
//
//            @Override
//            protected boolean exec() {
//                return false;
//            }
//        });

        //RecursiveAction没有返回值
        forkJoinPool.invoke(new RecursiveAction() {
            @Override
            protected void compute() {
                System.out.printf("[Thread : %s] Hello World...\n", Thread.currentThread().getName());
            }
        });

        forkJoinPool.shutdown();
    }
}
