package org.example.SynchronizationAndConcurrence;

import java.util.Map;

public class AddToMap implements Runnable{
    private final Map<Integer, Integer> sharedMap;
    private int n;
    private int turn;

    AddToMap(Map<Integer, Integer> sharedMap, int n, int turn) {
        this.sharedMap = sharedMap;
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
            sharedMap.put(i, i);
        }
        System.out.println("Thread ID: " + turn + " is done!");
    }
}
