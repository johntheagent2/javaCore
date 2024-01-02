package org.example.SynchronizationAndConcurrence;

import java.util.List;

public class AddToList implements Runnable {
    private final List<Integer> sharedList;
    private final int n;
    private final int turn;

    AddToList(List<Integer> sharedList, int n, int turn) {
        this.sharedList = sharedList;
        this.n = n;
        this.turn = turn;
    }

    @Override
    public void run() {
            for (int i = 0; i < n; i++) {
                // Simulate some work before adding to the list
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Add an element to the shared list
                sharedList.add(i);
            }
            System.out.println("Thread ID: " + turn + " is done!");
    }
}
