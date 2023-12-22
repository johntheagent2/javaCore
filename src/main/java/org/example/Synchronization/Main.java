package org.example.Synchronization;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Create a shared list
        List<Integer> sharedList = new ArrayList<>();
        //        sharedList = Collections.synchronizedList(sharedList);
        Set<Integer> sharedSet = new HashSet<>();
//        sharedSet = Collections.synchronizedSet(sharedSet);
        Map<Integer, Integer> sharedMap = new HashMap<>();
        sharedMap = Collections.synchronizedMap(sharedMap);
        int n = 30;

        // Create four threads that add elements to the list
//        Thread thread1 = new Thread(new SyncVsUnsync.AddToList(sharedList, n, 1));
//        Thread thread2 = new Thread(new SyncVsUnsync.AddToList(sharedList, n, 2));
//        Thread thread3 = new Thread(new SyncVsUnsync.AddToList(sharedList, n, 3));
//        Thread thread4 = new Thread(new SyncVsUnsync.AddToList(sharedList, n, 4));

        // Create four threads that add elements to the set
//        Thread thread1 = new Thread(new SyncVsUnsync.AddToSet(sharedSet, n, 1));
//        Thread thread2 = new Thread(new SyncVsUnsync.AddToSet(sharedSet, n, 2));
//        Thread thread3 = new Thread(new SyncVsUnsync.AddToSet(sharedSet, n, 3));
//        Thread thread4 = new Thread(new SyncVsUnsync.AddToSet(sharedSet, n, 4));

        // Create four threads that add elements to the map
        Thread thread1 = new Thread(new AddToMap(sharedMap, n, 1));
        Thread thread2 = new Thread(new AddToMap(sharedMap, n, 2));
        Thread thread3 = new Thread(new AddToMap(sharedMap, n, 3));
        Thread thread4 = new Thread(new AddToMap(sharedMap, n, 4));

        // Start the threads
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
        System.out.println("Final: " + sharedMap);
        System.out.println("Size: " + sharedMap.size());

    }
}