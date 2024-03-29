package collections.list;

import java.util.*;

// legacy
// slow because sync
// similar to ArrayList but synchronized
// has some methods not in the Collection framework

public class VectorExample {
    public static void main(String args[]) {

        Vector<String> v = new Vector<String>();
        v.add("Ayush");
        v.add("Amit");
        v.add("Ashish");
        v.add("Garima");

        Iterator<String> itr = v.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }
}
