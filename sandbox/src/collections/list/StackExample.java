package collections.list;

import java.util.*;

// subclass of Vector. It implements the LIFO data structure, i.e., Stack.
// contains all of the methods of Vector class + boolean push(), boolean peek(), boolean push(object o)

public class StackExample {


    public static void main(String args[]) {
        Stack<String> stack = new Stack<String>();

        stack.push("First");
        stack.push("Second");
        stack.push("bla");
        stack.push("before last");
        stack.push("Last");

        System.out.println("last is " + stack.peek());
        System.out.println("pop " + stack.pop());
        System.out.println("last is " + stack.peek());

        Iterator<String> itr = stack.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
