package org.example.OOP;

public abstract class Animal {
    protected int numOfLegs;
    protected String name;
    protected String makeSound;

    public Animal(String name, int numOfLegs, String makeSound){
        this.name = name;
        this.numOfLegs = numOfLegs;
        this.makeSound = makeSound;
    }

    public int getNumOfLegs() {
        return numOfLegs;
    }

    public void setNumOfLegs(int numOfLegs) {
        this.numOfLegs = numOfLegs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMakeSound() {
        return makeSound;
    }

    public void setMakeSound(String makeSound) {
        this.makeSound = makeSound;
    }

    public abstract void makeSound();
}
