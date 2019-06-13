package algorithms.sortingAndSearching;

import java.util.Arrays;

//  worst-case and average complexity of О(n2) -> bad

public class BubbleSort {

    public static void main(String[] args) {
        int[] input = {6, 4, 3, 7, 1, 12, 9, 8, 9, 10};


        System.out.println("array " + Arrays.toString(input));
        sort(input);
        System.out.println("array " + Arrays.toString(input));
    }

    static void sort(int[] arr) {
        boolean madeSwaps = false;
        int tmp = 0;
        do {
            madeSwaps = false;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i]>arr[i+1]){
                    tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    madeSwaps = true;
                }
            }
        } while (madeSwaps);


        System.out.println("done");
    }
}
