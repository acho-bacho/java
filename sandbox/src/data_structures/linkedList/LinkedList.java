package data_structures.linkedList;

 class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this();
        this.data = data;
    }

    public Node() {
        this.next = null;
    }

    public void show() {
        System.out.println("{ " + data + " } ");
    }

     @Override
     public String toString() {
         return Integer.toString(data);
     }
 }

public class LinkedList {
    private Node head;

    public boolean isEmpty() {
        return (head == null);
    }

    // used to insert a node at the start of linked list
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // used to delete node from start of linked list
    public Node deleteFirst() {
        Node temp = head;
        head = head.next;
        return temp;
    }

    // Use to delete node after particular node
    public void deleteAfter(Node after) {
        Node temp = head;
        while (temp.next != null && temp.data != after.data) {
            temp = temp.next;
        }
        if (temp.next != null)
            temp.next = temp.next.next;
    }

    public void insertAfter(Node after, int data) {
        Node tmp = head;
        while (tmp.next!=null && tmp.data!=after.data) {
            tmp = tmp.next;
        }
        if(tmp.next!=null) {
            Node newNode = new Node(data);
            newNode.next = tmp.next;
            tmp.next = newNode;
        }
    }

    // used to insert a node at the start of linked list
    public void insertLast(int data) {
        Node last = head;
        while (last.next != null) {
            last = last.next; // we'll loop until current.next is null
        }
        Node newNode = new Node(data);
        last.next = newNode;
    }

    // For printing Linked List
    public void printLinkedList() {
        System.out.println("Printing LinkedList (head --> last) ");
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.toString()).append("->");
            current = current.next;
        }
        System.out.println(sb);
    }

    public void reverse(){
        Node prev = null;
        Node current = head;

        while(current!=null && current.next!=null){
            Node next = current.next;

            current.next = prev;

            //move ptr
            prev = current;
            current = next;
        }

        //at the end set HEAD
        head = current;
        if(head!=null)
            head.next = prev;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertFirst(4);
        list.insertFirst(2);
        list.insertFirst(1);

        list.insertAfter(new Node(2), 3);
        list.insertLast(5);
        list.printLinkedList();
    }
}
