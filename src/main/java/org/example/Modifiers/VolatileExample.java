package org.example.Modifiers;

public class VolatileExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // Create multiple threads sharing the same resource
        Thread thread1 = new Worker(sharedResource);
        Thread thread2 = new Worker(sharedResource);

        // Start the threads
        thread1.start();
        thread2.start();
    }

    public static class SharedResource {
        volatile boolean flag = false;
    }

    public static class Worker extends Thread {
        private final SharedResource sharedResource;

        public Worker(SharedResource sharedResource) {
            this.sharedResource = sharedResource;
        }

        @Override
        public void run() {
            // Thread-safe check and update of the volatile variable
            if (!sharedResource.flag) {
                System.out.println("Updating flag in " + Thread.currentThread().getName());
                sharedResource.flag = true;
            }
        }
    }
}
