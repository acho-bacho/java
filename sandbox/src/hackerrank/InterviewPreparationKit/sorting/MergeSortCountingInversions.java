package hackerrank.InterviewPreparationKit.sorting;

import java.util.Arrays;

// We basically implement MergeSort and
//  1) Add "swaps" counter and 1 line of code to count swaps when merging
//  2) Use "long" instead of "int" to avoid integer overflow

//  Time Complexity: O(n log n)
// Space Complexity: O(n)


public class MergeSortCountingInversions {
    private static long swaps = 0;

    public static void main(String[] args) {
        //int[] input = {6, 4, 3, 7, 1, 12, 9, 8, 9, 13};
        int[] input = {2, 1, 3, 1, 2};
        System.out.println("array " + Arrays.toString(input));
        long inv = countInversions(input);
        System.out.println("array " + Arrays.toString(input));
        System.out.println("inv = " + inv);
    }

    static long countInversions(int[] array) {
        swaps = 0;
        int [] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
        return swaps;
    }
    private static void mergeSort(int [] array, int [] helper, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, helper, start, mid);
            mergeSort(array, helper, mid + 1, end);
            merge(array, helper, start, mid, end);
        }
    }

    private static void merge(int [] array, int [] helper, int start, int mid, int end) {
        /* Fill helper array with same elements as original array */
        for (int i = start; i <= end; i++) { // notice "i" goes from "start" to "end", not "0" to "array.length"
            helper[i] = array[i];
        }

        int curr = start;
        int left = start;
        int right = mid + 1;

        /* Loop through helper[] left and right halves and continuously copy smaller element to array[] */
        while (left <= mid && right <= end) {
            if (helper[left] <= helper[right]) {
                array[curr++] = helper[left++];
            } else {
                    /* Each time we choose element from right side, we count up how many elements
                       it is less than from left side. This is equivalent to counting swaps. */
                swaps += mid + 1 - left;
                array[curr++] = helper[right++];
            }
        }

        /* Copy remaining elements of left half. Right half elements are already in proper place */
        while (left <= mid) {
            array[curr++] = helper[left++];
        }
    }
}

