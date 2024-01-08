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
        String sheetChosen = "sheet2";

        Customer customer = new Customer("CDP", "address1", 21);
        customerList.add(customer);
        customerList.add(new Customer("TTNA", "address2", 22));
        customerList.add(new Customer("VDC", "address3", 21));
        customerList.add(new Customer("ABC", "address7", 29));

//        normalInput();
//        normalOutput();
//        inputWithBuffer();
//        outputWithBuffer();

//        writeToCSV(customerList, fileNameCSV);
//        readCSV(fileNameCSV);

//        writeToExcel(customerList, fileNameExcel);
        readExcel(fileNameExcel, sheetChosen);
//
//        try {
//            Invoice.createInvoice(customer, fileNamePDF);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }


    public static void writeToExcel(List<Customer> customerList, String fileName) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        try{
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
            }finally {
                workbook.close();
            }

            System.out.println("Excel file created successfully: " + fileName);

        }catch (Exception e){
            System.out.println(e);
        }finally {
            workbook.close();
        }
    }

    public static void readExcel(String fileName, String sheetChosen) throws IOException {
        Workbook workbook = new XSSFWorkbook(new FileInputStream(fileName));
        try{
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

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            workbook.close();
        }
    }

    public static void writeToCSV(List<Customer> customerList, String filename) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(filename));
        try{
            String[] header = {"Name", "Address", "Age"};
            writer.writeNext(header);
            for (Customer customer : customerList) {
                String[] temp = {customer.getName(), customer.getAddress(), Integer.toString(customer.getAge())};
                writer.writeNext(temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            writer.close();
        }
    }

    public static void readCSV(String fileName) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(fileName));
        try {
            String[] nextLine;

            while ((reader.readNext()) != null) {
                nextLine = reader.readNext();

                for (String value : nextLine) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            reader.close();
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
            fis.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void normalOutput() throws IOException {
        FileOutputStream fos = new FileOutputStream("src/main/java/org/example/IOLibrary/files/fos.txt");
        try{

            String text = "Hello world! This is from FileOutputStream.";
            byte[] bytes = text.getBytes();

            fos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            fos.close();
        }
    }

    public static void inputWithBuffer() throws IOException {
        FileInputStream fisTemp = new FileInputStream("src/main/java/org/example/IOLibrary/files/bis.txt");
        BufferedInputStream bis = new BufferedInputStream(fisTemp);
        System.out.println();
        try{
            byte[] allByte = bis.readAllBytes();
            for(byte currentByte : allByte){
                System.out.print((char) currentByte);
            }

            fisTemp.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bis.close();
        }
    }

    public static void outputWithBuffer() throws IOException {
        FileOutputStream fosStream = new FileOutputStream("src/main/java/org/example/IOLibrary/files/bos.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fosStream);
        try{
            String text = "Hello world! This is from BufferedOutputStream.";
            byte[] bytes = text.getBytes();

            bos.write(bytes);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bos.close();
            fosStream.close();
        }
    }
}
