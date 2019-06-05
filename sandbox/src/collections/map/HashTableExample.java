package collections.map;

import java.util.*;

// slow legacy class
//
public class HashTableExample {

    public static void main(String args[]) {
        Hashtable<Integer, String> map = new Hashtable<Integer, String>();
        map.put(100, "Amit");
        map.put(102, "Ravi");
        map.put(101, "Vijay");
        map.put(103, "Rahul");
        System.out.println("Initial Map: " + map);

        //Inserts, as the specified pair is unique
        map.putIfAbsent(104, "Gaurav");

        System.out.println("Updated Map: " + map);

        //Returns the current value, as the specified pair already exist
        String value = map.putIfAbsent(101, "Vijay");
        if(value!=null){
            System.out.println("existing value is " + value);
            map.put(101, value+" updated");
        }

        System.out.println("Updated Map: " + map);
    }
}
