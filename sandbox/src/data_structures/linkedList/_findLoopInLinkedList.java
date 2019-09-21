package data_structures.linkedList;
/**
 * Use two pointer fastPtr and slowPtr and initialize both to head of linkedlist
 * Move fastPtr by two nodes and slowPtr by one node in each iteration.
 * If fastPtr and slowPtr meet at some iteration , then there is a loop in linkedlist.
 * If fastPtr reaches to the end of linkedlist without meeting slow pointer then there is no loop in linkedlist (i.e fastPtr->next or fastPtr->next->next become null)
 * */
public class _findLoopInLinkedList {
    public boolean ifLoopExists(Node head) {
        Node fastPtr = head;
        Node slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr)
                return true;
        }
        return false;
    }
}
