package collections.set.sortedSet;

import java.util.*;

public class TreeSetExample {
    public static void main(String args[]) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(24);
        set.add(66);
        set.add(12);
        set.add(15);

        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("Highest Value: " + set.pollFirst());
        System.out.println("Lowest Value: " + set.pollLast());



        TreeSet<String> strSet = new TreeSet<String>();
        strSet.add("A");
        strSet.add("B");
        strSet.add("C");
        strSet.add("D");
        strSet.add("E");

        System.out.println("Initial Set: " + strSet);

        System.out.println("Reverse Set: " + strSet.descendingSet());

        System.out.println("Head Set: " + strSet.headSet("C", true));

        System.out.println("SubSet: " + strSet.subSet("A", false, "E", true));

        System.out.println("TailSet: " + strSet.tailSet("C", false));

    }
}
