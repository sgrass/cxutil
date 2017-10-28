package org.cx.thread.threadlocal;

/**
 * @author grass
 * @date 2017/10/28
 */
public class Demo3 {

//    private static Index index = new Index();

    private static final ThreadLocal<Index> local = new ThreadLocal<Index>() {
        @Override
        protected Index initialValue() {
            return new Index();
        }
    };

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(()->{
                Index index = local.get();
                index.increase();
                local.set(index);

                System.out.printf("%s-->%s \n", Thread.currentThread().getName(), local.get().num);

                local.remove();
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }

    static class Index {
        int num;

        public void increase() {
            num++;
        }
    }
}
