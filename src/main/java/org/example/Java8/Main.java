package org.example.Java8;

import org.example.IOLibrary.Customer;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        functionalInterfaceExample();
//        streamExample1();
//        streamExample2();
//        optionalExample();
//        parallelStreamAPIExample();
        dateAndTimeAPIsExample();
//        mapExample();
//        testLambdaExpression();
    }

    public static void testLambdaExpression(){
//        Reference to a Static Method
        Function<String, String> myFunc = functionalReferenceExample::sayBye;
        System.out.println(myFunc.apply("Bob"));


//        Reference to an Instance Method of a Particular Object
        Customer customerA = new Customer("CDP", "address", 20);
        Runnable introduce = customerA::introduce;
        introduce.run();

//        Reference to an Instance Method of an Arbitrary Object of a Particular Type
        List<String> fruits = Arrays.asList("apple", "melon", "orange", "grape");
        Consumer<String> printReference = System.out::println;

        fruits.forEach(printReference);

//        Reference to a Constructor
        TriFunction<String, String, Integer, Customer> createCustomer = Customer::new;
        Customer customerB = createCustomer.apply("TTNA", "address1", 22);

        Runnable introduce1 = customerB::introduce;
        introduce1.run();
    }

    interface  TriFunction<T, U, V, R>{
        R apply(T t, U u, V v);
    }

    interface functionalReferenceExample{
        void sayHello(String name);

        default String sayIntro(String name){
            return "my name is " + name;
        }

        static String sayBye(String name){
            return name + " says bye!";
        }
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
        Optional<String> nonNullOptional = Optional.of("Hello, Java 8!");

        // Creating an Optional with a potentially null value
        String nullableValue = "This might be null";
        Optional<String> nullableOptional = Optional.ofNullable(nullableValue);

        // Creating an empty Optional
        Optional<String> emptyOptional = Optional.empty();

        // isPresent() - Check if a value is present
        System.out.println("nonNullOptional is present: " + nonNullOptional.isPresent());
        System.out.println("emptyOptional is present: " + emptyOptional.isPresent());

        // ifPresent() - Execute a block of code if a value is present
        nonNullOptional.ifPresent(value -> System.out.println("Value present: " + value));
        emptyOptional.ifPresent(value -> System.out.println("This won't be printed"));

        // orElse() - Get the value if present, otherwise return a default value
        String result1 = nonNullOptional.orElse("Default Value");
        String result2 = emptyOptional.orElse("Default Value");

        System.out.println("Result1: " + result1);
        System.out.println("Result2: " + result2);

        // orElseGet() - Get the value if present, otherwise invoke a supplier
        String result3 = nonNullOptional.orElseGet(supplierDefault::supply);
        String result4 = emptyOptional.orElseGet(supplierDefault::supply);

        System.out.println("Result3: " + result3);
        System.out.println("Result4: " + result4);

        // orElseThrow() - Get the value if present, otherwise throw an exception
        try {
            String result5 = emptyOptional.orElseThrow(() -> new IllegalArgumentException("Value is absent"));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // map() - Transform the value if present
        String transformedValue = nonNullOptional
                .map(s -> s + " - Transformed")
                .orElse("Default Value");
        System.out.println("Transformed Value: " + transformedValue);

        // filter() - Apply a condition to the value
        Optional<String> filteredOptional = nonNullOptional.filter(s -> s.contains("Java"));
        System.out.println("Filtered Optional: " + filteredOptional.orElse("No match"));

        // flatMap() - Transform the value and flatten the result
        Optional<String> flatMappedOptional = nonNullOptional.flatMap(s -> Optional.of(s + " - FlatMapped"));
        Optional<Optional<String>> nestedOptional = nonNullOptional.map(s -> Optional.of(s + " - FlatMapped"));

        System.out.println("FlatMapped Optional: " + flatMappedOptional.orElse("Default Value"));
        System.out.println("Mapped Nested Optional: " + nestedOptional.orElse(Optional.of("Default Value")));
    }

    public static void dateAndTimeAPIsExample(){
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);

        // Current time
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time: " + currentTime);

        // Current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + currentDateTime);

        // Formatting date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Formatted Date and Time: " + formattedDateTime);

        // Parsing a date string
        String dateString = "2022-01-01";
        LocalDate parsedDate = LocalDate.parse(dateString);
        System.out.println("Parsed Date: " + parsedDate);

        // Manipulating dates and times
        LocalDate futureDate = currentDate.plusDays(7);
        System.out.println("Date 7 days from now: " + futureDate);

        LocalTime modifiedTime = currentTime.minusHours(2);
        System.out.println("Time 2 hours ago: " + modifiedTime);

//        Duration represents a duration of time at the nanosecond precision, while Period represents a period of time in terms of years, months, and days.
        Duration duration = Duration.ofHours(3);
        Period period = Period.ofWeeks(2);
        System.out.println(duration.toMinutes());
        System.out.println(period.getDays());
    }

    interface supplierDefault{
        void create();

        static String supply(){
            return "Default supplier";
        }
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

        Map<Integer, Customer> mapOfCustomer = customers.stream()
                .collect(Collectors.toMap(customers::indexOf, (customer) -> customer));

        mapOfCustomer.forEach((key, customer) -> {
            System.out.print(key + " ");
            customer.introduce();
        });
    }

    public static void functionalInterfaceExample(){
        Animal cat = (soundType, repetitions) -> {
            for(int i = 0; i < repetitions; i++){
                System.out.println(soundType);
            }
        };
        cat.makeSound("meow", 2);
        cat.move();
        Animal.comeAlive();

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
    static void comeAlive() {
        System.out.println("All animals share some common behaviors.");
    }
}