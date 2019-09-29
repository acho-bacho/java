package hackerrank.InterviewPreparationKit.sorting;

import java.util.Arrays;

public class BubbleSort {


    public static void main(String[] args) {
        int[] input = {6, 4, 3, 7, 1, 12, 9, 8, 9, 10};


        System.out.println("array " + Arrays.toString(input));
        sort(input);
        System.out.println("array " + Arrays.toString(input));
    }

    static void sort(int[] arr) {
        boolean madeSwaps = false;
        int numSwaps=0;
        int tmp = 0;
        do {
            madeSwaps = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    madeSwaps = true;
                    numSwaps++;
                }
            }
        } while (madeSwaps);

        System.out.println(String.format("Array is sorted in %d swaps.", numSwaps));
        System.out.println(String.format("First Element: %d", arr[0]));
        System.out.println(String.format("Last Element: %d", arr[arr.length-1]));



        System.out.println("done");
    }

}
