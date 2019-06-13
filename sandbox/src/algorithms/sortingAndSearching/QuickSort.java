package algorithms.sortingAndSearching;


// https://www.geeksforgeeks.org/quick-sort/
// O(n log n)


import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] input = {6, 4, 3, 13, 1, 12, 9, 8, 9, 7};

        System.out.println("array " + Arrays.toString(input));
        quickSort(input, 0, input.length - 1);
        System.out.println("array " + Arrays.toString(input));

    }

    static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int pivot = partition(arr, low, high);

            System.out.println("after pivot " + Arrays.toString(arr));

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }

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
                System.out.println("j = " + j);
                System.out.println("s = " + s);
                swap(arr, s,j);
            }
        }
        //at the end of the loop 's' will have the position of the last smaller
        // so s+1 is the right position for pivot
        swap(arr, s+1, high);

        return s+1;
    }


    static void swap(int[] arr, int i, int j) {
        System.out.println(String.format("Swappping %d with %d", arr[i], arr[j]));
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        System.out.println("After swap " + Arrays.toString(arr));
    }
}
