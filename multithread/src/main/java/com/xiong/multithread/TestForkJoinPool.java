package com.xiong.multithread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class TestForkJoinPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(20);
        ForkJoinTask<Integer> submit = forkJoinPool.submit(new Task(1, 300000));
        Integer integer = submit.get();
        System.out.println(integer);
    }

    static class Task extends RecursiveTask<Integer> {
        private int start;
        private int end;
        private static final int threshold = 2;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int sum = 0;
            if (end - start > threshold) {
                int mid = start + (end-start) / 2;
                Task task = new Task(start, mid);
                Task task1 = new Task(mid + 1, end);
                task.fork();
                task1.fork();
                int i = task.join() + task1.join();
                sum+=i;
            } else {
                for (int i = start; i <= end; i++) {
                    sum+=i;
                }
            }

            return sum;
        }
    }
}
