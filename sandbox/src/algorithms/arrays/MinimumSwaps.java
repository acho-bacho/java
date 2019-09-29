package algorithms.arrays;

import java.util.Arrays;

public class MinimumSwaps {
    static int minimumSwaps(int[] array) {
        int n = array.length - 1;
        int minSwaps = 0;
        for (int i = 0; i < n; i++) {
            if (i < array[i] - 1) { //array[i] is not at right positions
                swap(array, i, Math.min(n, array[i] - 1));
                minSwaps++;
                i--; //if we swapped, we want i not to increment
            }
        }
        return minSwaps;
    }

    private static void swap(int[] array, int i, int j) {
        System.out.println("swap elemnt at = " + i + " " + j);
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        System.out.println(">> "+Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 3, 2, 4, 5, 6};
        System.out.println(Arrays.toString(arr));
        int minswaps = minimumSwaps(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(minswaps);
    }
}
