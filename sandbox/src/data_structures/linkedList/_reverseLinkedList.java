package data_structures.linkedList;

public class _reverseLinkedList {
    public static Node reverseLinkedList(Node currentNode)
    {
        // For first node, previousNode will be null
        Node previousNode=null;
        Node nextNode;
        while(currentNode!=null)
        {
            nextNode=currentNode.next;

            // reversing the link
            currentNode.next=previousNode;

            // moving currentNode and previousNode by 1 node
            previousNode=currentNode;
            currentNode=nextNode;
        }
        return previousNode;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.printLinkedList();

        //AKIT implementation
        list.reverse();
        list.printLinkedList();

        //reverse empty
        list = new LinkedList();
        list.reverse();
        list.printLinkedList();
    }
}
