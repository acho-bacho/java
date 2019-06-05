package collections.map;

import java.util.*;

// preserves order

public class LinkedHashMapExample {
    public static void main(String args[]) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();

        map.put(102, "Rahul");
        map.put(100, "Amit");
        map.put(101, "Vijay");


        //Fetching key
        System.out.println("Keys: " + map.keySet());

        //Fetching value
        System.out.println("Values: " + map.values());

        //Fetching key-value pair
        System.out.println("Key-Value pairs: " + map.entrySet());


        System.out.println("Before invoking remove() method: " + map);
        map.remove(102);
        System.out.println("After invoking remove() method: " + map);

    }
}
