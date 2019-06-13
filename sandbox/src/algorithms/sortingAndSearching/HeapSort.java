package algorithms.sortingAndSearching;

import java.util.Arrays;

// O(n log n)

public class HeapSort {

    public static void main(String[] args) {
        //int[] input = {6, 4, 3, 7, 1, 12, 9, 8, 9, 13};
        int[] input = {1,2,10,5};

        System.out.println("array " + Arrays.toString(input));
        sort(input);
        System.out.println("array " + Arrays.toString(input));
    }

    static void sort(int arr[])
    {
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
        for (int end = (size-1); end>=0; end--)
        {
            //after heapify arr[0] is largest, so put it to end
            // Move current root to end
            int largest = arr[0];
            arr[0] = arr[end];
            arr[end] = largest;

            // call max heapify on the reduced heap (reduced as end is --)
            heapify(arr, 0, end);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[].
    static void heapify(int[] arr, int root, int size)
    {
        // pos of largest element
        int largest = root; // Initialize largest as root
        int l = 2*root + 1; // left = 2*i + 1
        int r = 2*root + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < size && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < size && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root -> swaping -> new call of heapify()
        if (largest != root)
        {
            //swap so that root is bigger than children
            int tmp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = tmp;
            System.out.println("** internal swap  = " + Arrays.toString(arr));
            // Recursively heapify the affected sub-tree
            heapify(arr, largest, size);
        }
    }
}
