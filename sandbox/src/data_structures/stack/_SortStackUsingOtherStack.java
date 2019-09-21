package data_structures.stack;

public class _SortStackUsingOtherStack {

    public static StackCustom sortStack(StackCustom stack) {
        StackCustom tempStack = new StackCustom(10);

        while (!stack.isEmpty()) {
            int currentData = stack.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > currentData) {
                stack.push(tempStack.pop());
            }
            tempStack.push(currentData);
        }

        return tempStack;
    }

    public static void main(String[] args) {
        StackCustom s = new StackCustom(10);
        s.push(1);
        s.push(7);
        s.push(5);
        s.push(2);
        s.push(3);
        s.push(6);
        s.push(4);
        s.print();
        System.out.println("sorted = ");
        sortStack(s).print();
    }
}
