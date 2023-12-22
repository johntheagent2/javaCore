package org.example.Synchronization;

import java.util.Set;

public class AddToSet implements Runnable{
    private final Set<Integer> sharedSet;
    private int n;
    private int turn;

    AddToSet(Set<Integer> sharedSet, int n, int turn) {
        this.sharedSet = sharedSet;
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
            sharedSet.add(i);
        }
        System.out.println("Thread ID: " + turn + " is done!");
    }
}
