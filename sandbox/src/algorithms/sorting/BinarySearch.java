package algorithms.sorting;

// Given a sorted array arr[] of n elements, write a function to search a given element x in arr[].
// O(Log n)

public class BinarySearch {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int intToFind = 10;

        System.out.println("search(input) = " + binarySearch(input, intToFind, 0, input.length));
    }

    static int binarySearch(int[] arr, int x, int l, int r) {
        String output = String.format("x %d l %d r %d", x, l , r);

        if (r >= l) {

            int mid = l + (r - l) / 2;

            if(arr[mid] == x){
                System.out.println("Element " + x + " found at pos " + mid);
                return mid;
            }

            if(arr[mid] > x) {
                return binarySearch(arr, x, l, mid-1);
            }

            //if(arr[mid] < x) {
                return binarySearch(arr, x, mid + 1, r);
            //}
        }

        System.out.println("Element " + x + " not found");
        return -1;
    }
}
