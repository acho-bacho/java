package collections.map;

import java.util.*;

public class HashMapExample {

    public static void main(String args[]) {
        Map<Integer, String> map = new HashMap<Integer, String>();

        map.put(102, "Rahul");
        map.put(100, "Amit");
        map.put(101, "Vijay");


        map.putIfAbsent(103, "Gaurav");

        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        System.out.println("<<<<<<<");

        //Returns a Set view of the mappings contained in this map
        map.entrySet()
                //Returns a sequential Stream with this collection as its source
                .stream()
                //Sorted according to the provided Comparator
                .sorted(Map.Entry.comparingByKey())
                //Performs an action for each element of this stream
                .forEach(System.out::println);

        System.out.println("<<<<<<<");


        //Returns a Set view of the mappings contained in this map
        map.entrySet()
                //Returns a sequential Stream with this collection as its source
                .stream()
                //Sorted according to the provided Comparator
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                //Performs an action for each element of this stream
                .forEach(System.out::println);


        //key-based removal
        map.remove(100);
        System.out.println("Updated list of elements: " + map);
        //value-based removal
        map.remove(101);
        System.out.println("Updated list of elements: " + map);
        //key-value pair based removal
        map.remove(102, "Rahul");

        map.replace(103, "NewGaurav");

        System.out.println("Updated list of elements: " + map);
    }
}
