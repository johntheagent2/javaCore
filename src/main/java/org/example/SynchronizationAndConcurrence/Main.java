package org.example.SynchronizationAndConcurrence;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Main {
    public static void main(String[] args) {

        // Create a shared list
        List<Integer> sharedList = new ArrayList<>();
        sharedList = Collections.synchronizedList(sharedList);

        Set<Integer> sharedSet = new HashSet<>();
//        sharedSet = Collections.synchronizedSet(sharedSet);

        Map<Integer, Integer> sharedMap = new HashMap<>();
//        sharedMap = Collections.synchronizedMap(sharedMap);

        ConcurrentHashMap<Integer, Integer> concurrentMap = new ConcurrentHashMap<>();
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

        int n = 30;


//        // Create four threads that add elements to the list
        Thread thread1 = new Thread(new AddToList(sharedList, n, 1));
        Thread thread2 = new Thread(new AddToList(sharedList, n, 2));
        Thread thread3 = new Thread(new AddToList(sharedList, n, 3));
        Thread thread4 = new Thread(new AddToList(sharedList, n, 4));

//         Create four threads that add elements to the set
//        Thread thread1 = new Thread(new AddToSet(sharedSet, n, 1));
//        Thread thread2 = new Thread(new AddToSet(sharedSet, n, 2));
//        Thread thread3 = new Thread(new AddToSet(sharedSet, n, 3));
//        Thread thread4 = new Thread(new AddToSet(sharedSet, n, 4));

        // Create four threads that add elements to the map
//        Thread thread1 = new Thread(new AddToMap(sharedMap, n, 1));
//        Thread thread2 = new Thread(new AddToMap(sharedMap, n, 2));
//        Thread thread3 = new Thread(new AddToMap(sharedMap, n, 3));
//        Thread thread4 = new Thread(new AddToMap(sharedMap, n, 4));

        // Create four threads that add elements to the concurrence map
//        Thread thread1 = new Thread(new AddToMap(concurrentMap, n, 1));
//        Thread thread2 = new Thread(new AddToMap(concurrentMap, n, 2));
//        Thread thread3 = new Thread(new AddToMap(concurrentMap, n, 3));
//        Thread thread4 = new Thread(new AddToMap(concurrentMap, n, 4));


//        // Create four threads that add elements to copy on write list
//        Thread thread1 = new Thread(new AddToList(copyOnWriteArrayList, n, 1));
//        Thread thread2 = new Thread(new AddToList(copyOnWriteArrayList, n, 2));
//        Thread thread3 = new Thread(new AddToList(copyOnWriteArrayList, n, 3));
//        Thread thread4 = new Thread(new AddToList(copyOnWriteArrayList, n, 4));

//Create four threads that add elements to copy on write set
//        Thread thread1 = new Thread(new AddToSet(sharedSet, n, 1));
//        Thread thread2 = new Thread(new AddToSet(sharedSet, n, 2));
//        Thread thread3 = new Thread(new AddToSet(sharedSet, n, 3));
//        Thread thread4 = new Thread(new AddToSet(sharedSet, n, 4));

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
        System.out.println("Final: " + sharedList);
        System.out.println("Size: " + sharedList.size());

    }
}