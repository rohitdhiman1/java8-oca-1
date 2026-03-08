package com.ocp.multithreading;

/**
 * This class demonstrates the two basic ways to create and run a thread in Java.
 * 1. Extending the Thread class.
 * 2. Implementing the Runnable interface.
 *
 * Implementing Runnable is generally preferred as it allows the class to extend other classes,
 * promoting better object-oriented design.
 */

// Method 1: Extending the Thread class
class MyThread extends Thread {
    private String threadName;

    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    // The run() method contains the code that will be executed by the new thread.
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " - Count: " + i);
            try {
                // Pause the thread for a short time to simulate work
                Thread.sleep(500); // 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }
        }
        System.out.println(threadName + " has finished.");
    }
}

// Method 2: Implementing the Runnable interface
class MyRunnable implements Runnable {
    private String runnableName;

    public MyRunnable(String runnableName) {
        this.runnableName = runnableName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(runnableName + " - Count: " + i);
            try {
                Thread.sleep(700); // 700 milliseconds
            } catch (InterruptedException e) {
                System.out.println(runnableName + " was interrupted.");
            }
        }
        System.out.println(runnableName + " has finished.");
    }
}


public class MultithreadingExample {
    public static void main(String[] args) {
        System.out.println("Main thread started.");

        // Create and start a thread by extending Thread
        MyThread thread1 = new MyThread("Thread-A (extends Thread)");
        thread1.start(); // The start() method calls the run() method in a new thread.

        // Create and start a thread by implementing Runnable
        MyRunnable myRunnable = new MyRunnable("Thread-B (implements Runnable)");
        Thread thread2 = new Thread(myRunnable);
        thread2.start();

        // Using a lambda expression with Runnable (since it's a functional interface)
        Runnable runnableLambda = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread-C (Lambda) - Count: " + i);
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread-C (Lambda) has finished.");
        };
        Thread thread3 = new Thread(runnableLambda);
        thread3.start();

        System.out.println("Main thread finished its tasks and is now waiting for other threads to complete.");
    }
}
