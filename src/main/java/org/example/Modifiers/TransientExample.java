package org.example.Modifiers;

import java.io.*;

public class TransientExample {
    public static void main(String[] args) {
        // Create an object
        SerializableObject obj = new SerializableObject("John", 25);

        // Serialize the object
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
            out.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the object
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.ser"))) {
            SerializableObject restoredObj = (SerializableObject) in.readObject();
            System.out.println("Name: " + restoredObj.name);
            System.out.println("Age: " + restoredObj.age);
            System.out.println("Sensitive Data: " + restoredObj.sensitiveData);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class SerializableObject implements Serializable {
        // This variable will not be serialized
        transient int sensitiveData = 42;

        // Other non-transient variables
        String name;
        int age;

        public SerializableObject(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
