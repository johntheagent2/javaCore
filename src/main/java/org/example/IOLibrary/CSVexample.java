package org.example.IOLibrary;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVexample {
    public static void main(String[] args){
        List<Customer> customerList = new ArrayList<>();
        String filename = "output.csv";
        customerList.add(new Customer("CDP", "address1", 21));
        customerList.add(new Customer("TTNA", "address2", 22));
        customerList.add(new Customer("VDC", "address3", 21));

        writeToCSV(customerList, filename);
        readCSV(filename);
    }

    public static void writeToCSV(List<Customer> customerList, String filename){
        try (CSVWriter writer = new CSVWriter(new FileWriter(filename))) {
            String[] header = {"Name", "Address", "Age"};
            writer.writeNext(header);
            for(Customer customer : customerList){
                String[] temp = {customer.getName(), customer.getAddress(), Integer.toString(customer.getAge())};
                writer.writeNext(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readCSV(String fileName){
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                for (String value : nextLine) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
