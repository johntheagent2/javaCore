package org.example.OOP;

public class Main {
    public static void main(String[] args){
        Animal human = new Human("Bob", 2, "hi", 20);
        Animal dog = new Dog("Lucky", 4, "bark");

        human.makeSound();
        dog.makeSound();
    }
}
