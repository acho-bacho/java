package algorithms.sorting;

import java.util.Arrays;

// O(n log n)

public class HeapSort {

    public static void main(String[] args) {
        //int[] input = {6, 4, 3, 7, 1, 12, 9, 8, 9, 13};
        int[] input = {1, 2, 10, 5};

        System.out.println("array " + Arrays.toString(input));
        sort(input);
        System.out.println("array " + Arrays.toString(input));
    }

    static void sort(int arr[]) {
        int size = arr.length;

        // Build heap (rearrange array)
        // (size / 2 - 1) is  the start root and we go backwards
        for (int rootPos = size / 2 - 1; rootPos >= 0; rootPos--) {
            heapify(arr, rootPos, size);
        }

        // after heapify the largest element is at pos 0
        System.out.println("after first heapify = " + Arrays.toString(arr));

        // One by one extract an element from heap
        // and put it to ordered list at the end
        // 'end' marks the end of the heap, after that starts the sorted part
        for (int end = (size - 1); end >= 0; end--) {
            //after heapify arr[0] is largest, so put it to end
            // Move current root to end
            swap(arr, 0, end);
            // call max heapify on the reduced heap (reduced as end is --)
            heapify(arr, 0, end);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[].
    static void heapify(int[] arr, int rootPos, int heapSize) {
        // pos of largest element
        int largest = rootPos; // Initialize largest as root
        int l = 2 * rootPos + 1; // left = 2*i + 1
        int r = 2 * rootPos + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < heapSize && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < heapSize && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root -> swaping -> new call of heapify()
        if (largest != rootPos) {
            //swap so that root is bigger than children
            swap(arr, rootPos, largest);

            System.out.println("** internal swap  = " + Arrays.toString(arr));

            // Recursively heapify the affected sub-tree
            heapify(arr, largest, heapSize);
        }
    }

    static void swap(int[] arr, int i, int j) {
        System.out.println(String.format("Swappping %d with %d", arr[i], arr[j]));
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        System.out.println("After swap " + Arrays.toString(arr));
    }
}
