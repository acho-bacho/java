package data_structures.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public StackUsingTwoQueues() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    public void push(int elem) {
        System.out.println("pushing " + elem);
        if(q1.size()==0){
            q1.add(elem);
        } else {
            q2.clear();
            int size1 = q1.size();

            for (int i = 0; i < size1; i++) {
                q2.add(q1.remove());
            }
            q1.clear();
            q1.add(elem);
            for (int i = 0; i < size1; i++) {
                q1.add(q2.remove());
            }
        }
    }
    public int pop(){
        if(q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int elem = q1.remove();
        System.out.println("removing " + elem);
        return elem;
    }
    public void print(){
        System.out.println(q1.toString());
    }
    public static void main(String[] args) {
        StackUsingTwoQueues stack = new StackUsingTwoQueues();
        stack.push(20);
        stack.push(40);
        stack.push(70);
        stack.push(50);
        stack.push(90);
        stack.push(110);
        stack.push(30);
        stack.print();

        stack.pop();
        stack.print();
        stack.push(170);
        stack.print();
        stack.pop();
        stack.print();
    }
}
