package com.ocp.concurrency;

/**
 * This class demonstrates a basic concurrency problem (a race condition)
 * and how to solve it using the 'synchronized' keyword.
 *
 * A race condition occurs when multiple threads access and manipulate shared data concurrently,
 * and the result of the operation depends on the unpredictable timing of their execution.
 */

class Counter {
    private int count = 0;

    // A non-thread-safe increment method.
    public void incrementUnsafe() {
        count++;
    }

    // A thread-safe increment method using the 'synchronized' keyword.
    // The 'synchronized' keyword ensures that only one thread can execute this method
    // on a given instance of Counter at a time. It acquires a lock on the object.
    public synchronized void incrementSafe() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class ConcurrencyExample {

    public static void main(String[] args) throws InterruptedException {
        runUnsafeExample();
        System.out.println("\n--------------------------\n");
        runSafeExample();
    }

    public static void runUnsafeExample() throws InterruptedException {
        System.out.println("--- Unsafe (Race Condition) Example ---");
        Counter unsafeCounter = new Counter();

        // Create two threads that will increment the counter.
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                unsafeCounter.incrementUnsafe();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                unsafeCounter.incrementUnsafe();
            }
        });

        thread1.start();
        thread2.start();

        // Wait for both threads to finish.
        thread1.join();
        thread2.join();

        // The expected result is 20000, but due to the race condition,
        // the actual result will likely be less.
        System.out.println("Final count (unsafe): " + unsafeCounter.getCount());
    }

    public static void runSafeExample() throws InterruptedException {
        System.out.println("--- Safe (Synchronized) Example ---");
        Counter safeCounter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                safeCounter.incrementSafe();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                safeCounter.incrementSafe();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        // With synchronization, the result will always be the expected 20000.
        System.out.println("Final count (safe): " + safeCounter.getCount());
    }
}
