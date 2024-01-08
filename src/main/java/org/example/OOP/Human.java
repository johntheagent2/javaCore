package org.example.OOP;

public class Human extends Animal{

    private final int age;

    public Human(String name, int numOfLegs, String makeSound, int age) {
        super(name, numOfLegs, makeSound);
        this.age = age;
    }

    private int getAge() {
        return age;
    }

    @Override
    public void makeSound(){
        System.out.println("Human is "+ getAge()  +" and talk " + getMakeSound());
    }
}
