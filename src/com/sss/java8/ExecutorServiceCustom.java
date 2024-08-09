package com.sss.java8;

import java.util.concurrent.LinkedBlockingQueue;


public class ExecutorServiceCustom {
    static int capacity;
    static int currentCapacity = 0;
    static LinkedBlockingQueue<Runnable> linkedTaskBlockingQueue = new LinkedBlockingQueue<>();;

    static class Execution implements Runnable {
        public void run() {
            while (true) {
                if (!linkedTaskBlockingQueue.isEmpty()) {
                    linkedTaskBlockingQueue.poll().run();
                }
            }
        }
    }

    public static void main(String[] args) {
        ExecutorServiceCustom.capacity = 3;
        for (int i = 0; i < 20; i++) {
            linkedTaskBlockingQueue.add(new Worker());
            if (currentCapacity < capacity) {
                currentCapacity++;
                Thread t = new Thread(new Execution());
                t.start();
            }
        }
        Runnable runnableTask = null;
    }
}

class Worker implements Runnable {
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Current Thread :-> " + Thread.currentThread().getName());
    }
}


