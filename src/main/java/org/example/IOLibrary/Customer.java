package org.example.IOLibrary;

public class Customer {
    private String name;
    private String address;
    private int age;

    public Customer(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void introduce(){
        System.out.println("My name is " + this.name + " and I'm " + this.age + " my address is " + this.address);
    }

}
