package org.cx.thread.java9;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 *
 * {@link java.util.concurrent.SubmissionPublisher}
 * @author grass
 * @date 2017/11/19
 */
public class SubmissionPublisherDemo {

    public static void main(String[] args) throws InterruptedException {

        //实现AutoCloseable接口的使用 try表达式可自动关闭
        try(SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>()) {

            publisher.subscribe(new IntegerSubscribe("A"));
            publisher.subscribe(new IntegerSubscribe("B"));
            publisher.subscribe(new IntegerSubscribe("C"));



            CompletableFuture<Void> completableFuture = publisher.consume(value->{
                System.out.printf("Current Thread[%s] consume value[%s] \n", Thread.currentThread().getName(), value);
            }).thenRunAsync(()->{
                System.out.printf("Current Thread[%s] thenRunAsync \n", Thread.currentThread().getName());
            });

            //提交数据到各个订阅器
            publisher.submit(100);
        };

        //相当于try(){};
//        try {
//
//        } finally {
//            publisher.close();
//        }

        Thread.currentThread().join(1000L);

    }

    public static class IntegerSubscribe implements Flow.Subscriber<Integer> {

        public final String name;

        private Flow.Subscription subscription;

        public IntegerSubscribe(String name) {
            this.name = name;
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            System.out.printf("Thread[%s] Current Subscriber[%s] subscribes[%s] \n",
                    Thread.currentThread().getName(), name, subscription);

            subscription.request(1);

            this.subscription = subscription;
        }

        @Override
        public void onNext(Integer item) {
            System.out.printf("Thread[%s] Current Subscriber[%s] receives item[%d] \n",
                    Thread.currentThread().getName(), name, item);

            subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            System.out.printf("Thread[%s] Current Subscriber[%s] is complete \n",
                    Thread.currentThread().getName(), name, subscription);
        }
    }

}
