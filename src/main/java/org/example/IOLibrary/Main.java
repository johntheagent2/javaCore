package org.example.IOLibrary;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("src/IOLibrary/files/fis.txt");
            byte[] allByte = fis.readAllBytes();
            for(byte currentByte : allByte){
                System.out.print((char) currentByte);
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            fis.close();
        }

        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream("src/IOLibrary/files/fos.txt");

            String text = "Hello world! This is from FileOutputStream.";
            byte[] bytes = text.getBytes();

            fos.write(bytes);
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            fos.close();
        }

        FileInputStream fisTemp = new FileInputStream("src/IOLibrary/files/bis.txt");
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

        FileOutputStream fosStream = new FileOutputStream("src/IOLibrary/files/bos.txt");
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
