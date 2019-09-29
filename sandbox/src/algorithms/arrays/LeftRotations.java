package algorithms.arrays;

import java.util.Arrays;

public class LeftRotations {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] result = new int[a.length];
        int size = a.length;
        int rotations = d%size;

        // LEFT ROTATIONS
        //find position of first element, then only increment
        int pos = (size-rotations);

        for (int i = 0; i < size; i++) {
            if(pos==size) {
                pos=0;
            }
            result[pos] = a[i];
            pos++;
        }
        return result;
    }

    static int[] rotRight(int[] a, int d) {
        int[] result = new int[a.length];
        int size = a.length;
        int rotations = d%size;

        // RIGHT ROTATIONS
        //find position of first element, then only increment
        int pos = (size+rotations)%size;

        for (int i = 0; i < size; i++) {
            if(pos==size) {
                pos=0;
            }
            result[pos] = a[i];
            pos++;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(arr));
        int[] rotated = rotLeft(arr, 9);
        int[] rotatedRight = rotRight(arr, 9);
        System.out.println(Arrays.toString(rotated));
        System.out.println(Arrays.toString(rotatedRight));
    }
}
