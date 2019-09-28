package learning_java_examples;

import java.util.Arrays;
import java.util.List;

public class ArraysExample {
    public static void main(String[] args) {
        String[][] twoDimenArr = new String[2][4];
        twoDimenArr[0][1] = "set.";
        for (String[] s : twoDimenArr) {
            System.out.println(Arrays.toString(s));
        }

        int[][] differentSize = {{1, 4}, {3}, {9, 8, 7}};
        for (int[] i : differentSize) {
            System.out.println(Arrays.toString(i));
        }

        int[][] myargs = new int[4][];
        myargs[0] = new int[5];
        myargs[1] = new int[3];

        String[] array = {"hawk", "robin"}; // [hawk, robin]
        List<String> list = Arrays.asList(array); // returns fixed size list
        System.out.println(list.size()); // 2
        list.set(1, "test"); // [hawk, test]
        array[0] = "new"; // [new, test]
        for (String b : array)
            System.out.print(b + " "); // new test

        list.add("third new");// throws UnsupportedOperation Exception
        list.remove(1); // throws UnsupportedOperation Exception


        List<String> list2 = Arrays.asList("one", "two"); //var args
        List<String> list3 = Arrays.asList(array);
        int[] arrRef = null;
        arrRef = new int[]{};
    }
}
