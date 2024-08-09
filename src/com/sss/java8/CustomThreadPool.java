package com.sss.java8;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class CustomThreadPool {

    public static void main(String[] args) {
        BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, taskQueue);
        for (int i = 0; i < 10; i++) {
            executor.execute(new Task(i));
        }
        executor.shutdown();
    }

    static class Task implements Runnable {
        private int taskId;
        public Task(int taskId) {
            this.taskId = taskId;
        }
        @Override
        public void run() {
            System.out.println("Executing task " + taskId);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}