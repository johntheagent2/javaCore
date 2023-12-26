package org.example.Java8;

import org.example.IOLibrary.Customer;

import java.util.*;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        functionalInterfaceExample();
//        streamExample1();
//        streamExample2();
//        optionalExample();
//        parallelStreamAPIExample();
        mapExample();
    }

    public static void mapExample(){
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("pine apple");
        fruits.add("melon");
        fruits.add("banana");

        String[] fruitStatus = {"rotten", "not rotten"};

        Map<Integer, String> stringMap = fruits.stream()
                .collect(Collectors.toMap(fruits::indexOf, fruit -> (fruit + " " + fruitStatus[new Random().nextInt(2)]).toUpperCase()));

        stringMap.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public static void parallelStreamAPIExample(){
        List<Integer> listOfNumbers = new ArrayList<>();
        for(int i = 0; i < 10000; i++){
            listOfNumbers.add(i);
        }


        long startTimeParallel = System.currentTimeMillis();
        List<String> parallelStringList = listOfNumbers.parallelStream()
                .map(number -> "cdp-"+number)
                .map(String::toUpperCase)
                .toList();
        long endTimeParallel = System.currentTimeMillis();


        System.out.println("Time taken for parallel stream: " + (endTimeParallel - startTimeParallel) + " milliseconds");

    }

    public static void optionalExample(){
        // Creating an Optional with a non-null value
        Optional<String> nameOptional = Optional.of("John");

        // Creating an empty Optional
        Optional<String> emptyOptional = Optional.empty();

        // Checking if the Optional has a value
        if (nameOptional.isPresent()) {
            System.out.println("Name: " + nameOptional.get());
        } else {
            System.out.println("Name is absent.");
        }

        // Using orElse to provide a default value if the Optional is empty
        String defaultName = emptyOptional.orElse("Default");
        System.out.println("Default Name: " + defaultName);

        // Using ifPresent to perform an action if the Optional has a value
        nameOptional.ifPresent(name -> System.out.println("Length of Name: " + name.length()));

        // Example of chaining methods
        String result = nameOptional.map(String::toUpperCase)
                .orElse("No value")
                .concat("!");
        System.out.println("Result: " + result);
    }

    public static void streamExample2(){
        List<Integer> numbers = new ArrayList<>();
        int i =0;

        while(numbers.size() < 50){
            numbers.add(i++);
        }

        int smallestInList = numbers.stream()
                .min(Comparator.naturalOrder()).get();

        int largestInList = numbers.stream()
                .max(Comparator.naturalOrder()).get();

        System.out.println(smallestInList + " " + largestInList);


        List<Integer> oddNumbersOnly = numbers.stream()
                .limit(10)
                .filter(oddNumber -> oddNumber % 2 == 1)
                .toList();

        oddNumbersOnly.forEach(number -> System.out.print(number + " "));

        List<String> turnNumberToString = oddNumbersOnly.stream()
                .map(integer -> "CDP" + integer)
                .toList();

        turnNumberToString.forEach(System.out::println);
    }

    public static void streamExample1(){
        List<Customer> customers =  new ArrayList<>();
        customers.add(new Customer("Cao Duc Phat", "address1", 21));
        customers.add(new Customer("Nguyen Van A", "address2", 18));
        customers.add(new Customer("Ta Thi Ngoc Anh", "address3", 22));
        customers.add(new Customer("Tran Van Tuan Quoc", "address4", 30));

        List<Customer> genZCustomers = customers.stream()
                .filter(customer -> customer.getAge() < 30)
                .sorted(Comparator.comparingInt(Customer::getAge))
                .toList();

        genZCustomers = Collections.unmodifiableList(genZCustomers);

        try{
            genZCustomers.add(new Customer("Tran Van Tuan Quoc", "address4", 30));
        }catch (Exception e){
            System.out.println("Tried to change a unmodifiable List");
        }finally {
            genZCustomers.forEach(customer -> System.out.println(customer.getName() + " " + customer.getAge()));
        }
    }

    public static void functionalInterfaceExample(){
        Animal cat = (soundType, repetitions) -> {
            for(int i = 0; i < repetitions; i++){
                System.out.println(soundType);
            }
        };
        cat.makeSound("meow", 2);
        cat.move();
        Animal.commonBehavior();

        Animal bob = new Human();
        bob.makeSound("hi", 3);
        bob.move();
    }
}

class Human implements Animal{
    @Override
    public void makeSound(String sound, int repetitions) {
        for(int i = 0; i < repetitions; i++){
            System.out.println(sound);
        }
    }
}

@FunctionalInterface
interface Animal {
    // Abstract method
    void makeSound(String sound, int repetitions);

    // Default method
    default void move() {
        System.out.println("The animal is moving.");
    }

    // Static method
    static void commonBehavior() {
        System.out.println("All animals share some common behaviors.");
    }
}