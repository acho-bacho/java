package data_structures.linkedList;


/*
* Use two pointer firstPtr and secondPtr and initialize both to head of linkedlist
* Move firstPtr by n-1 nodes.
* Increment firstPtr and secondPtr until firstPtr.next not equal to null.
* SecondPtr will be at nth from end node.
* */
public class _findNthFromLastElement {

    public Node nthFromLastNode(Node head, int n) {
        Node firstPtr = head;
        Node secondPtr = head;

        for (int i = 0; i < n; i++) {
            firstPtr = firstPtr.next;

        }

        while (firstPtr != null) {
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }

        return secondPtr;
    }
}
