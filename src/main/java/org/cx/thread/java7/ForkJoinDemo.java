package org.cx.thread.java7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * 步骤1，分割任务。首先需要一个fork类把大任务分割成子任务，有可能子任务还是很大，
 *      所以还需要不停的分割，直到分割出的子任务足够小。
 * 步骤2，执行任务并且合并结果。
 *      分割的子任务分别放在双端队列里，然后几个启动线程分别从双端队里里获取任务执行。
 *      子任务执行完的结果都统一放在一个队列里，启动一个线程从队列里拿数据，然后合并这些数据。
 *
 * fork/join使用两个类来完成以上两件事情
 *
 * {@link ForkJoinTask}: 要使用forkjoin框架，首先必须创建一个forkjoin任务。它提供在任务中执行fork()和join()操作的机制。
 *                      通常情况，不需要继承ForkJoinTask类，只需要继承它的子类，提供两个子类
 *                      {@link RecursiveAction}: 用于没有返回结果的任务
 *                      {@link RecursiveTask}: 用于有返回结果的任务
 *
 * {@link ForkJoinPool}: ForkJoinTask需要通过ForkJoinPool来执行
 *
 * 任务分割出的子任务会添加到当前工作线程所维护的双端队列中，进入队列的头部。
 * 当一个工作线程的队列里暂时没有任务时，它会随机从其他工作线程的队列的尾部获取一个任务。
 *
 * invoke()  同步，有返回结果 （会阻塞）
 * execute() 异步，无返回结果
 * submit()  异步，有返回结果 （返回Future<T>）
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
