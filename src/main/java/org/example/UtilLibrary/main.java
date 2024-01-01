package org.example.UtilLibrary;

import java.io.*;
import java.util.*;

class main{
    public static void main(String[] args) throws IOException {

        Integer[] arr = {1,1,0,2,3,4,5};
        List<Integer> arrList = new ArrayList<>();

        listExample(arrList, arr);
        linkedListExample(arrList, arr);
        stackExample(arr);
        hashMapExample();
        hashTableExample();
        setExample(arrList);
        collectionsExample(arr ,arrList);
        vectorExample();
        propertiesExample();
        resourceBundleExample();
        calenderExample();
        enumExample();
    }

    public static void listExample(List<Integer> arrList, Integer[] arr){
        print("array List");
        arrList = Arrays.asList(arr);

        print(arrList.subList(0,3));
        print(arrList);
        printDevider();
    }

    public static void linkedListExample(List<Integer> arrList, Integer[] arr){
        print("Linked list");

        arrList = Arrays.asList(arr);
        LinkedList<Integer> linkedList = new LinkedList<>(arrList);

        print(linkedList);
        print(linkedList.pop());
        print(linkedList.pop());
        print(linkedList);
        printDevider();
    }

    public static void stackExample(Integer[] arr){
        print("stack");
        Stack<Integer> stack = new Stack<>();
        for(Integer temp : arr){
            stack.push(temp);
        }
        print(stack);
        print(stack.peek());
        print(stack);

        print(stack.pop());
        print(stack.pop());

        print(stack);
        printDevider();
    }

    public static void hashMapExample(){
        print("hash map");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "foo");
        map.put(2, "bar");
        map.put(null, null);
        print(map);
        print(map.get(2));
        printDevider();
    }

    public static void hashTableExample(){
        print("hash table"); //no null key or value allowed
        Hashtable<Integer, String> table = new Hashtable<>();
        table.put(1, "foo");
        table.put(2, "bar");
        // table.put(null, null);
        print(table);
        print(table.get(2));
        printDevider();
    }

    public static void setExample(List<Integer> arrList){
        Set<Integer> set = new HashSet<>();
        set.addAll(arrList);
        print(set);
        printDevider();
    }

    public static void dateExample(){
        print("date");
        Date date = new Date();
        print(date);
        print(date.getTime());
        printDevider();
    }

    public static void collectionsExample(Integer[] arr, List<Integer> arrList){
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
    }

    public static void vectorExample(){
        print("Vector");
        Vector<Object> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add("Hello");
        vector.add(3);

        print(vector);
        vector.remove(1);
        print(vector);
        printDevider();
    }

    public static void propertiesExample() throws IOException {
        print("Properties");
        FileReader reader = new FileReader("src/main/resources/test.txt");

        Properties properties = new Properties();
        properties.load(reader);

        Set tempSet = properties.entrySet();

        Iterator itr = tempSet.iterator();
        while(itr.hasNext()){
            Map.Entry entry=(Map.Entry)itr.next();
            print(entry.getKey()+" = "+entry.getValue());
        }

        print(properties.getProperty("email"));
        print(properties.getProperty("password"));

        properties.store(new FileWriter("src/main/resources/test.txt"), "test");

        printDevider();
        print("XML loader");
        FileInputStream xmlReader = new FileInputStream("src/main/resources/test.xml");
        Properties xmlProperties = new Properties();
        try{
            xmlProperties.loadFromXML(xmlReader);

            xmlProperties.forEach((key, value) -> print(key + ": " + value));
        }catch (Exception e){
            e.printStackTrace();
        }

        xmlProperties.setProperty("key3", "value3");
        xmlProperties.setProperty("key4", "value4");

        try{
            FileOutputStream output = new FileOutputStream("src/main/resources/test.xml");
            xmlProperties.storeToXML(output, "Done stored");
        }catch (Exception e){
            e.printStackTrace();
        }
        printDevider();
    }

    public static void resourceBundleExample(){
        print("Resource Bundle");
        Locale localeEn = new Locale("en");
        Locale localeVn = new Locale("vn");
        ResourceBundle labelsUS = ResourceBundle.getBundle("lang/label", localeEn);
        ResourceBundle labelsVN = ResourceBundle.getBundle("lang/label", localeVn);
        print(labelsUS.getString("GREETING"));
        print(labelsVN.getString("GREETING"));
        printDevider();
    }

    public static void calenderExample(){
        print("Calender");
        Calendar calendar = Calendar.getInstance();
        print("Now: " + calendar.getTime());
        calendar.add(Calendar.DATE, -15);
        print("15 days: " + calendar.getTime());
        calendar.add(Calendar.MONTH, 4);
        print("4 months: " + calendar.getTime());
        calendar.add(Calendar.YEAR, 2);
        print("2 years: " + calendar.getTime());

        Calendar calendarNOW = Calendar.getInstance();
        print("YEAR: " + calendarNOW.get(Calendar.YEAR));
        print("MONTH: " + calendarNOW.get(Calendar.MONTH));
        print("DAY: " + calendarNOW.get(Calendar.DATE));
        print("DAY_OF_WEEK: " + calendarNOW.get(Calendar.DAY_OF_WEEK));

        print("DATE AND TIME: " + calendarNOW.getTime());

        int maximum = calendarNOW.getMaximum(Calendar.DAY_OF_YEAR);
        print(maximum);

        int minimum = calendarNOW.getMinimum(Calendar.DAY_OF_YEAR);
        print(minimum);
        printDevider();
    }

    public static void enumExample(){
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
        print("==================");
    }
}