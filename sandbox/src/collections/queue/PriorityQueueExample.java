package collections.queue;

import java.util.*;

public class PriorityQueueExample {
    public static void main(String args[]) {
        Queue<String> queue = new PriorityQueue<String>();

        queue.add("Cvetan");
        queue.add("Angel");
        queue.add("Boris");
        queue.add("Dimo");

        System.out.println("head:" + queue.element());
        System.out.println("head:" + queue.peek());

        System.out.println("iterating the queue elements:");
        Iterator itr = queue.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("removing -------------------------");
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }

        queue.poll();
        queue.poll();

        System.out.println("after removing two elements:");
        Iterator<String> itr2 = queue.iterator();
        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }

        // Integer
        PriorityQueue<Integer> prioQueue = new PriorityQueue<Integer>();

        prioQueue.add(2);
        prioQueue.add(11);
        prioQueue.add(1);
        prioQueue.add(3);

        itr = prioQueue.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("removing");
        while (!prioQueue.isEmpty()) {
            System.out.println(prioQueue.remove());
        }

    }
}
