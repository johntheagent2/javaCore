package org.example.OOP;

public class Dog extends Animal{

    public Dog(String name, int numOfLegs, String makeSound) {
        super(name, numOfLegs, makeSound);
    }

    @Override
    public void makeSound(){
        System.out.println("Dog talk " + getMakeSound());
    }
}
