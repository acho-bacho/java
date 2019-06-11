package algorithms.sortingAndSearching;

// Given a sorted array arr[] of n elements, write a function to search a given element x in arr[].
// O(Log n)

public class BinarySearch {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int intToFind = 10;


        // my solution
        System.out.println("search(input) = " + binarySearch(input, intToFind, 0, input.length - 1));

        //website solution 1
        int result = binarySearch2(input, 0, input.length - 1, intToFind);
        System.out.println("website soltion 1 " + result);

        //website solution 2
        System.out.println("website soltion 2 " + binarySearch3(input, intToFind));
    }

    static int binarySearch(int[] arr, int x, int l, int r) {

        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x) {
                System.out.println("Element " + x + " found at pos " + mid);
                return mid;
            }

            if (arr[mid] > x) {
                return binarySearch(arr, x, l, mid - 1);
            }

            //if(arr[mid] < x) {
            return binarySearch(arr, x, mid + 1, r);
            //}
        }

        System.out.println("Element " + x + " not found");
        return -1;
    }


    // solution from website
    // Returns index of x if it is present in arr[l..
    // r], else return -1
    static int binarySearch2(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch2(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch2(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }

    // solution from website: Iterative

    static int binarySearch3(int arr[], int x) {

        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr[m] == x)
                return m;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }
}
