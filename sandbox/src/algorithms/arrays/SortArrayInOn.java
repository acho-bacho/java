package algorithms.arrays;

import java.util.*;
import java.lang.*;

// Sort array in O(n)
// array is ASC until MIDDLE then DESC

public class SortArrayInOn {
    public static void main(String[] args) {

        int[] input = {1, 25, 30, 50, 40, 30, 26};
        //int[] input = {1,10,2};
        System.out.println(Arrays.toString(sort(input)));
    }

    static int[] sort(int[] inputArr) {
        int size = inputArr.length;
        int[] result = new int[size];

        int i = 0, r = size - 1, n = 0;

        for (; i != r; n++) {
            if (inputArr[i] < inputArr[r]) {
                result[n] = inputArr[i];
                i++;
            } else {
                result[n] = inputArr[r];
                r--;
            }
        }

        result[n] = inputArr[i];

        return result;
    }
}
