package org.example.IOLibrary;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Customer> customerList = new ArrayList<>();
        String fileNameCSV = "src/main/java/org/example/IOLibrary/files/outputCSV.csv";
        String fileNameExcel = "src/main/java/org/example/IOLibrary/files/outputExcel.xlsx";
        String fileNamePDF = "src/main/java/org/example/IOLibrary/files/invoice.pdf";
        String sheetChosen = "sheet1";
        Customer customer = new Customer("CDP", "address1", 21);

        customerList.add(customer);
        customerList.add(new Customer("TTNA", "address2", 22));
        customerList.add(new Customer("VDC", "address3", 21));

        normalInput();
        normalOutput();
        inputWithBuffer();
        outputWithBuffer();

        writeToCSV(customerList, fileNameCSV);
        readCSV(fileNameCSV);

        writeToExcel(customerList, fileNameExcel);
        readExcel(fileNameExcel, sheetChosen);

        try {
            Invoice.createInvoice(customer, fileNamePDF);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void writeToExcel(List<Customer> customerList, String fileName) throws IOException {
        try(Workbook workbook = new XSSFWorkbook()){
            Sheet sheet1 = workbook.createSheet("Sheet1");
            Sheet sheet2 = workbook.createSheet("Sheet2");
           int rowNum = 0;

           for(Customer customer : customerList){
               Row rowOfSheet1 = sheet1.createRow(rowNum);
               Row rowOfSheet2 = sheet2.createRow(rowNum++);
               int colNum = 0;
               Object[] currentCustomer = {customer.getName(), customer.getAge(), customer.getAddress()};

               for(Object customerProperties : currentCustomer){
                   Cell cellOfSheet1 = rowOfSheet1.createCell(colNum);
                   Cell cellOfSheet2 = rowOfSheet2.createCell(colNum++);

                   System.out.println(customerProperties);
                   if (customerProperties instanceof String) {
                       cellOfSheet1.setCellValue((String) customerProperties);
                       cellOfSheet2.setCellValue((String) customerProperties);
                   } else if (customerProperties instanceof Integer) {
                       cellOfSheet1.setCellValue((Integer) customerProperties);
                       cellOfSheet2.setCellValue((Integer) customerProperties);
                   }
               }
           }
            try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
                workbook.write(outputStream);
            }

            System.out.println("Excel file created successfully: " + fileName);

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void readExcel(String fileName, String sheetChosen){
        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(fileName))) {
            Sheet sheet = workbook.getSheet(sheetChosen);

            // Iterate through rows and columns
            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        default:
                            System.out.print("\t");
                    }
                }
                System.out.println(); // Move to the next line for the next row
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public static void normalInput() throws IOException {
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("src/main/java/org/example/IOLibrary/files/fis.txt");
            byte[] allByte = fis.readAllBytes();
            for(byte currentByte : allByte){
                System.out.print((char) currentByte);
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            fis.close();
        }
    }

    public static void normalOutput() throws IOException {

        try (FileOutputStream fos = new FileOutputStream("src/main/java/org/example/IOLibrary/files/fos.txt")) {

            String text = "Hello world! This is from FileOutputStream.";
            byte[] bytes = text.getBytes();

            fos.write(bytes);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void inputWithBuffer() throws FileNotFoundException {
        FileInputStream fisTemp = new FileInputStream("src/main/java/org/example/IOLibrary/files/bis.txt");
        BufferedInputStream bis = new BufferedInputStream(fisTemp);
        System.out.println();
        try{
            byte[] allByte = bis.readAllBytes();
            for(byte currentByte : allByte){
                System.out.print((char) currentByte);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void outputWithBuffer() throws FileNotFoundException{
        FileOutputStream fosStream = new FileOutputStream("src/main/java/org/example/IOLibrary/files/bos.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fosStream);
        try{
            String text = "Hello world! This is from BufferedOutputStream.";
            byte[] bytes = text.getBytes();

            bos.write(bytes);
            bos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
