package collections.queue.deque;

import java.util.*;

// ArrayDeque is faster than ArrayList and Stack and has no capacity restrictions.

public class ArrayDequeExample {
    public static void main(String[] args) {

        //Creating Deque and adding elements
        Deque<String> deque = new ArrayDeque<String>();
        deque.add("Gautam");
        deque.add("Karan");
        deque.add("Ajay");
        deque.addLast("Angel");
        deque.addFirst("AAA");

        //Traversing elements
        for (String str : deque) {
            System.out.println(str);
        }
    }
}
