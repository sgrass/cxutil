package org.cx.thread.java7;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author grass
 * @date 2017/11/15
 */
public class ForJoinDemo3 {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //累加对象
        LongAdder longAdder = new LongAdder();

        //RecursiveAction递归操作
        AddTask addTask = new AddTask(nums, longAdder);

        forkJoinPool.invoke(addTask);

        forkJoinPool.shutdown();

        System.out.println(longAdder);
    }

    private static class AddTask extends RecursiveAction {

        private final List<Integer> nums;

        private final LongAdder longAdder;

        private AddTask(List<Integer> nums, LongAdder longAdder) {
            this.nums = nums;
            this.longAdder = longAdder;
        }

        @Override

        protected void compute() {
            int size = nums.size();

            if (size > 1) {
                //二分部分数
                int parts = size / 2;

                //左半部分
                List<Integer> leftParts = nums.subList(0, parts);

                AddTask leftTask = new AddTask(leftParts, longAdder);

                //右半部分
                List<Integer> rightParts = nums.subList(parts, size);

                AddTask rightTask = new AddTask(rightParts, longAdder);

                invokeAll(leftTask, rightTask);

            } else {
                //当前元素只有一个
                if (size == 0) {
                    return;
                }
                Integer value = nums.get(0);

                //累加
                longAdder.add(value);
            }


        }
    }
}
