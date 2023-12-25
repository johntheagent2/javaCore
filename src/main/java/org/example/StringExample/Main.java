package org.example.StringExample;

import org.example.Synchronization.AddToList;

public class Main {
    public static void main(String[] args){
        StringBuffer stringBuffer= new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();

        int n=10;

        Thread thread1 = new Thread(new StringMultiThread(stringBuffer, stringBuilder, n, 1));
        Thread thread2 = new Thread(new StringMultiThread(stringBuffer, stringBuilder, n, 2));
        Thread thread3 = new Thread(new StringMultiThread(stringBuffer, stringBuilder, n, 3));
        Thread thread4 = new Thread(new StringMultiThread(stringBuffer, stringBuilder, n, 4));
//        Thread thread2 = new Thread(new StringMultiThread(stringBuffer, n, 2));
//        Thread thread3 = new Thread(new StringMultiThread(stringBuffer, n, 3));
//        Thread thread4 = new Thread(new StringMultiThread(stringBuffer, n, 4));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            // Wait for four threads to finish
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final contents of the list
        System.out.println("Final: " + stringBuilder);
        System.out.println("Size: " + stringBuilder.length());
        System.out.println("Final: " + stringBuffer);
        System.out.println("Size: " + stringBuffer.length());
    }
}
