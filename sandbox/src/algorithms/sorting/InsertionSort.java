package algorithms.sorting;

import java.util.Arrays;

// О(n2)

public class InsertionSort {

    public static void main(String[] args) {
        int[] input = {6, 4, 3, 7, 1, 12, 9, 8, 9, 13};

        System.out.println("array " + Arrays.toString(input));
        sort(input);
        System.out.println("array " + Arrays.toString(input));
    }

    static void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int j = i - 1;

            while (j >= 0 && arr[j] > arr[j + 1]) {
                //swap
                int tmp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = tmp;

                j--;
            }
        }
        System.out.println("done");
    }

}
