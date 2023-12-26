package org.example.UntilLibrary;

import java.io.*;
import java.util.*;

class main{
    public static void main(String[] args) throws IOException {

        Integer[] arr = {1,1,0,2,3,4,5};

        print("array List");
        List<Integer> arrList = new ArrayList<>();
        
        arrList = Arrays.asList(arr);

        print(arrList.subList(0,3));
        print(arrList);
        printDevider();

        print("Linked list");
        LinkedList<Integer> linkedList = new LinkedList<>(arrList);
        print(linkedList);
        print(linkedList.pop());
        print(linkedList.pop());
        print(linkedList);
        printDevider();

        print("stack");
        Stack<Integer> stack = new Stack<>();
        for(Integer temp : arr){
            stack.push(temp);
        }
        print(stack);
        System.out.println(stack.peek());
        print(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        print(stack);
        printDevider();

        print("hash map");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "foo");
        map.put(2, "bar");
        map.put(null, null);
        print(map);
        System.out.println(map.get(2));
        printDevider();

        print("hash table"); //no null key or value allowed
        Hashtable<Integer, String> table = new Hashtable<>();
        table.put(1, "foo");
        table.put(2, "bar");
        // table.put(null, null);
        print(table);
        System.out.println(table.get(2));
        printDevider();

        print("Set");
        Set<Integer> set = new HashSet<>();
        set.addAll(arrList);
        print(set);
        printDevider();

        print("date");
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.getTime());
        printDevider();
        
        print("collections");
        Set<Integer> set2 = new HashSet<>();

        Collections.addAll(set2, arr);
        Collections.sort(arrList);
        print(arrList);
        Collections.shuffle(arrList);
        print(arrList);
        Collections.sort(arrList);

        print(Collections.frequency(arrList, 1));
        print(arrList);
        print(set2);
        printDevider();

        print("Vector");
        Vector vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add("Hello");
        vector.add(3);

        print(vector);
        vector.remove(1);
        print(vector);
        printDevider();

        print("Properties");
        FileReader reader = new FileReader("src/main/java/org/example/UntilLibrary/test.txt");

        Properties properties = new Properties();
        properties.load(reader);

        Set tempSet = properties.entrySet();  

        Iterator itr = tempSet.iterator();  
        while(itr.hasNext()){  
            Map.Entry entry=(Map.Entry)itr.next();  
            System.out.println(entry.getKey()+" = "+entry.getValue());  
        }  

        print(properties.getProperty("email"));
        print(properties.getProperty("password"));

        properties.store(new FileWriter("src/main/java/org/example/UntilLibrary/test.txt"), "test");

        printDevider();
        System.out.println("XML loader");
        FileInputStream xmlReader = new FileInputStream("src/main/java/org/example/UntilLibrary/test.xml");
        Properties xmlProperties = new Properties();
        try{
            xmlProperties.loadFromXML(xmlReader);

            xmlProperties.forEach((key, value) -> System.out.println(key + ": " + value));
        }catch (Exception e){
            e.printStackTrace();
        }

        xmlProperties.setProperty("key3", "value3");
        xmlProperties.setProperty("key4", "value4");

        try{
            FileOutputStream output = new FileOutputStream("src/main/java/org/example/UntilLibrary/test.xml");
            xmlProperties.storeToXML(output, "Done stored");
        }catch (Exception e){
            e.printStackTrace();
        }


        printDevider();

        print("Resource Bundle");
        Locale localeEn = new Locale("en");
        Locale localeVn = new Locale("vn");
        ResourceBundle labelsUS = ResourceBundle.getBundle("lang/label", localeEn);
        ResourceBundle labelsVN = ResourceBundle.getBundle("lang/label", localeVn);
        System.out.println(labelsUS.getString("GREETING"));
        System.out.println(labelsVN.getString("GREETING"));
        printDevider();

        print("Calender");
        Calendar calendar = Calendar.getInstance();
        System.out.println("Now: " + calendar.getTime());
        calendar.add(Calendar.DATE, -15);
        System.out.println("15 days: " + calendar.getTime());
        calendar.add(Calendar.MONTH, 4);
        System.out.println("4 months: " + calendar.getTime());
        calendar.add(Calendar.YEAR, 2);
        System.out.println("2 years: " + calendar.getTime());

        Calendar calendarNOW = Calendar.getInstance();
        System.out.println("YEAR: " + calendarNOW.get(Calendar.YEAR));
        System.out.println("MONTH: " + calendarNOW.get(Calendar.MONTH));
        System.out.println("DAY: " + calendarNOW.get(Calendar.DATE));
        System.out.println("DAY_OF_WEEK: " + calendarNOW.get(Calendar.DAY_OF_WEEK));

        System.out.println("DATE AND TIME: " + calendarNOW.getTime());

        int maximum = calendarNOW.getMaximum(Calendar.DAY_OF_YEAR);
        System.out.println(maximum);

        int minimum = calendarNOW.getMinimum(Calendar.DAY_OF_YEAR);
        System.out.println(minimum);
        printDevider();

        print("ENUM");
        print("Status number of " + statusCode.NOT_FOUND + " is " + statusCode.NOT_FOUND.getStatusNumber());
        print("Status number of " + statusCode.OK + " is " + statusCode.OK.getStatusNumber());
        printDevider();

        print("Iterator");
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(12);
        numbers.add(8);
        numbers.add(2);
        numbers.add(23);
    
        Iterator<Integer> iter = numbers.iterator();

        while(iter.hasNext()){
            Integer current = iter.next();
            if(current == 2){
                iter.remove();
            }
        }
        print(numbers);
        
    }

    public static void print(Object object){
        System.out.println(object);
    }

    public static void printDevider(){
        System.out.println("==================");
    }
}