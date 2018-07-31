package com.interview;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This problem was asked by Apple.
 * <p>
 * Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
 */
class Operation implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello, mates!");
    }
}

public class Solution10 {
    private final int POOLSIZE = 5;
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOLSIZE);

    private void scheduleTask(Operation f, int n) {
        executor.schedule(f, n, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        Solution10 scheduler = new Solution10();
        scheduler.scheduleTask(new Operation(), 5000);
        scheduler.scheduleTask(new Operation(), 1000);
    }
}