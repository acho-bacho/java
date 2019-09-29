package algorithms.sorting;

import java.util.Arrays;

// https://www.geeksforgeeks.org/merge-sort/
// O(n log n)

public class MergeSort {
    public static void main(String[] args) {
        int[] input = {6, 4, 3, 7, 1, 12, 9, 8, 9, 13};

        System.out.println("array " + Arrays.toString(input));
        mergeSort(input, 0, input.length - 1);
        System.out.println("array " + Arrays.toString(input));
    }

    static void mergeSort(int[] arr, int l, int r) {

        if (l < r) {

            // 1. Find the middle point to divide the array into two halves:
            int m = (l + r) / 2;

            // 2. Call mergeSort for first half:
            mergeSort(arr, l, m);

            // 3. Call mergeSort for second half:
            mergeSort(arr, m + 1, r);

            // 4. Merge the two halves sorted in step 2 and 3:
            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r) {

        // get sizes of two arrays
        int s1 = m - l + 1;
        int s2 = r - m;

        // create two arrays
        int[] L = new int[s1];
        int[] R = new int[s2];

        // fill the two arrays
        for (int i = 0; i < s1; i++) {
            L[i] = arr[l + i];
        }

        for (int j = 0; j < s2; j++) {
            R[j] = arr[m + j + 1];
        }

        // sort them

        // left + right counters
        int i = 0, j = 0;
        int k;

        for (k = l; (k <= r) && (i < s1) && (j < s2); k++) {
            if (L[i] < R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
        }

        //add leftovers
        while (i < s1) {
            arr[k++] = L[i++];
        }
        while (j < s2) {
            arr[k++] = R[j++];
        }

    }
}
