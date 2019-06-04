package collections.list;

import java.util.*;

public class ArrayListExample {

    public static void main(String[] args) {

        List<String> al = new ArrayList<>();

        al.add("Ravi");
        al.add("Vijay");
        al.add("Ravi");
        al.add("Ajay");

        Iterator itr = al.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        for (String s : al) {
            System.out.println(s);
        }

        System.out.println("get element at " + al.get(0));
    }
}

