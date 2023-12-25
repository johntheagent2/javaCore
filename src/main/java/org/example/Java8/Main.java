package org.example.Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args){
        Supplier<Double> supplier = () -> Math.random();

        double number = supplier.get();
        System.out.println(number);


        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(8);
        numbers.add(20);
        numbers.add(15);

        numbers.replaceAll((n) -> add(n));

        numbers.forEach((n) -> System.out.println(n));
    }

    public static int add(int number){
        return number + 2;
    }
}
