package data_structures.queue;

// Class for queue
public class Queue {
    private int arr[];        // array to store queue elements
    private int front;        // front points to front element in the queue (if any)
    private int rear;        // rear points to last element in the queue
    private int capacity;    // maximum capacity of the queue
    private int currentSize;        // current size of the queue

    // Constructor to initialize queue
    Queue(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        front = 0;
        rear = -1;
        this.currentSize = 0;
    }

    // Utility function to add an item to the queue
    //i.e. moving the rear
    public void enqueue(int item) {
        // check for queue overflow
        if (isFull()) {
            System.out.println("OverFlow\nProgram Terminated");
            System.exit(1);
        }

        System.out.println("Inserting " + item);

        rear = (rear + 1) % capacity; // EQUALS TO if(rear == capacity-1) {rear = 0;}
        arr[rear] = item;
        currentSize++;
    }

    // Utility function to remove front element from the queue
    // i.e. moving the front
    public void dequeue() {
        // check for queue underflow
        if (isEmpty()) {
            System.out.println("UnderFlow\nProgram Terminated");
            //System.exit(1);
        }

        System.out.println("Removing " + arr[front]);

        front = (front + 1) % capacity;
        currentSize--;
    }



    // Utility function to return front element in the queue
    public int peek() {
        if (isEmpty()) {
            System.out.println("UnderFlow\nProgram Terminated");
            System.exit(1);
        }
        return arr[front];
    }

    // Utility function to return the size of the queue
    public int size() {
        return currentSize;
    }

    // Utility function to check if the queue is empty or not
    public Boolean isEmpty() {
        return (size() == 0);
    }

    // Utility function to check if the queue is empty or not
    public Boolean isFull() {
        return (size() == capacity);
    }

    public static void main(String[] args) {
        // create a queue of capacity 5
        Queue q = new Queue(5);

        q.enqueue(11);
        q.enqueue(22);
        q.enqueue(33);
        q.enqueue(44);
        q.enqueue(55);

        q.dequeue();
        q.enqueue(66);
        q.dequeue();
        q.enqueue(77);
        q.dequeue();
        q.enqueue(88);
        q.dequeue();
        q.enqueue(99);
        q.dequeue();
        q.enqueue(100);

        System.out.println("Front element is: " + q.peek());
        q.dequeue();
        System.out.println("Front element is: " + q.peek());

        System.out.println("Queue size is " + q.size());

        q.dequeue();
        q.dequeue();

        if (q.isEmpty())
            System.out.println("Queue Is Empty");
        else
            System.out.println("Queue Is Not Empty");
    }
}
