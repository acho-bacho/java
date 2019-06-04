package collections.list;

import java.util.*;

public class LinkedListExample {
    public static void main(String args[]) {

        LinkedList<String> ll = new LinkedList<String>();

        ll.add("Ravi");
        ll.add("Vijay");
        ll.add("Ravi");
        ll.add("Ajay");

        Iterator<String> itr = ll.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("get element at " + ll.get(0));
    }
}
