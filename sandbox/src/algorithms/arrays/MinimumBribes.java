package algorithms.arrays;

import java.util.Arrays;

//https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

public class MinimumBribes {

    static void minBribes(int[] arr) {
        int bribes = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int expPosition = arr[i]; //the value of the element is its expected pos
            int actualPosition = (i + 1);
            if (expPosition - actualPosition > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, arr[i] - 2);    j < i;         j++)
                if (arr[j] > arr[i]) {
                    bribes++;
                }
        }
        System.out.println(bribes);
    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 3, 4};
        //int[] arr = {2, 5, 1, 3, 4};
        //int[] arr = {1, 2, 5, 3, 7, 8, 6, 4};
        System.out.println(Arrays.toString(arr));

        minBribes(arr);
    }
}
