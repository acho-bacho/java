package algorithms.sortingAndSearching;

import java.util.Arrays;

// O(n log n)

public class HeapSort {

    public static void main(String[] args) {
        int[] input = {6, 4, 3, 7, 1, 12, 9, 8, 9, 13};

        System.out.println("array " + Arrays.toString(input));
        sort(input);
        System.out.println("array " + Arrays.toString(input));
    }

    static void sort(int arr[])
    {
        int size = arr.length;

        // Build heap (rearrange array)
        // why size / 2 - 1
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, size, i);
        }

        // after heapify the largest element is at pos 0
        System.out.println("after first heapify = " + Arrays.toString(arr));

        // One by one extract an element from heap
        // and put it to ordered list at the end
        for (int newSize=size-1; newSize>=0; newSize--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[newSize];
            arr[newSize] = temp;

            // call max heapify on the reduced heap
            heapify(arr, newSize, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heapify(int arr[], int size, int rootPos)
    {
        int largest = rootPos; // Initialize largest as root
        int l = 2*rootPos + 1; // left = 2*i + 1
        int r = 2*rootPos + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < size && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < size && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != rootPos)
        {
            int swap = arr[rootPos];
            arr[rootPos] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, size, largest);
        }
    }
}
