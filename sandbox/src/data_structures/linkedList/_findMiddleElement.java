package data_structures.linkedList;

public class _findMiddleElement {
    // This function will find middle element in linkedlist
    public Node findMiddleNode(Node head) {
        Node slowPointer, fastPointer;
        slowPointer = fastPointer = head;

        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            if (fastPointer != null && fastPointer.next != null) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }
        }

        return slowPointer;

    }
}
