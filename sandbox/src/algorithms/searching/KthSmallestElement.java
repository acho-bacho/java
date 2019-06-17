package algorithms.searching;

import java.util.Arrays;

// https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/
// O(n)
//Input: arr[] = {7, 10, 4, 3, 20, 15}
//       k = 3
//Output: 7
public class KthSmallestElement {

    public static void main(String[] args) {
        int arr[] = new int[]{12, 3, 5, 7, 4, 19, 26};
        int k = 3;


        System.out.print(String.format("%d'th smallest element in %s is %d", k, Arrays.toString(arr), kthSmallest1(arr, 0, arr.length - 1, k)));
    }


    /* This function takes last element as pivot, places
    the pivot element at its correct position in sorted
     array, and places all smaller (smaller than pivot)
    to left of pivot and all greater elements to right
    of pivot */
    static int partition(int[] arr, int low, int high) {

        // pivot (Element to be placed at right position)
        int pivot = arr[high];

        //index that keeps track of smaller elements
        int s = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {
                s++;
                swap(arr, s, j);
            }
        }
        //at the end of the loop 's' will have the position of the last smaller
        // so s+1 is the right position for pivot
        swap(arr, s + 1, high);

        return s + 1;
    }

    // This function returns k'th smallest element
    // in arr[l..r] using QuickSort based method.
    // ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT
    // The worst case time complexity of this method is O(n2),
    // but it works in O(n) on average.
    public static int kthSmallest1(int[] arr, int l, int r, int k) {

        // If k is smaller than number of elements
        // in array
        if (k > 0 && k <= r - l + 1) {
            // Partition the array around last
            // element and get position of pivot
            // element in sorted array
            int pos = partition(arr, l, r);

            // If position is same as k
            if (pos - l == k - 1) {
                return arr[pos];
            }

            // If position is more, recur for
            // left subarray
            if (pos - l > k - 1) {
                return kthSmallest1(arr, l, pos - 1, k);
            }

            // Else recur for right subarray
            return kthSmallest1(arr, pos + 1, r, k - pos + l - 1);
        }

        // If k is more than number of elements
        // in array
        return Integer.MAX_VALUE;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
