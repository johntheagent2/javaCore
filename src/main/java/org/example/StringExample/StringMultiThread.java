package org.example.StringExample;

import java.util.List;

public class StringMultiThread implements Runnable{
    private final StringBuilder stringBuilder;
    private final StringBuffer stringBuffer;
    private final int n;
    private final int turn;

    StringMultiThread(StringBuffer stringBuffer, StringBuilder stringBuilder, int n, int turn) {
        this.stringBuffer = stringBuffer;
        this.stringBuilder = stringBuilder;
        this.n = n;
        this.turn = turn;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            // Simulate some work before adding to the list
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Add an element to the shared list
            stringBuffer.append(i);
            stringBuilder.append(i);
        }
        System.out.println("Thread ID: " + turn + " is done!");
    }
}
