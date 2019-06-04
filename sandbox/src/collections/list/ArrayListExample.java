package collections.list;

import java.util.*;

public class ArrayListExample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Ravi");
        list.add("Vijay");
        list.add("Ravi");
        list.add("Ajay");

        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}

