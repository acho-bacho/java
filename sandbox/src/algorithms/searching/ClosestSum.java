package algorithms.searching;

// https://www.geeksforgeeks.org/given-sorted-array-number-x-find-pair-array-whose-sum-closest-x/

public class ClosestSum {


    public static void main(String[] args) {
        int[] arr = {10, 22, 28, 29, 30, 40};
        int sum = 54;
        printClosest(arr, sum);


        int[] arr2 = {1,4,5,6,7,30,41};
        sum = 45;
        printClosestBetter(arr2, sum);
    }

    // my simple solution
    // works in O(n^2)
    static void printClosest(int[] arr, int sum) {

        int a = 0, b = 0;
        //let´s say 10 is the max
        long delta = 10;

        for (int i = 0; i < arr.length; i++) {

            int j = i + 1;
            while (j < arr.length) {

                long diff = Math.abs(sum - (arr[i] + arr[j]));

                if (delta > diff) {
                    a = arr[i];
                    b = arr[j];
                    delta = diff;
                }
                j++;
            }
        }

        System.out.println(String.format("The sum of %d and %d is closest to %d", a, b, sum));
    }


    // works in O(n)
    static void printClosestBetter(int[] arr, int sum) {

        int a = 0, b = 0;
        int delta = Integer.MAX_VALUE;

        int l = 0;
        int r = arr.length - 1;


        while (l < r) {

            System.out.println(String.format("* l %d r %d size %d", l, r, arr.length));

            int diff = Math.abs(arr[l] + arr[r] - sum);

            // Check if this pair is closer than the closest pair so far
            if (diff < delta) {
                delta = diff;
                a = arr[l];
                b = arr[r];
            }

            // If this pair has more sum, move to smaller values. (array is sorted)
            if (arr[l] + arr[r] > sum) {
                r--;
            } else // Move to larger values
            {
                l++;
            }


        }
        System.out.println(String.format("* The sum of %d and %d is closest to %d", a, b, sum));
    }
}
