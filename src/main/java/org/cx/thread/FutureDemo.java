package org.cx.thread;

import java.util.concurrent.*;

/**
 * @author grass
 * @date 2017/11/15
 */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //线程池是线程复用
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello World";
            }
        });

        //等待完成
        while (true) {
            //知道当前操作是否完成
            if (future.isDone()) {
                break;
            }
        }

        //同步操作 future#get()方法阻塞当前线程
        String str = future.get();
        System.out.println(str);

        executorService.shutdown();
    }
}
