package algorithms.arrays;

import java.util.Arrays;

public class LeftRotations {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] result = new int[a.length];
        int size = a.length;
        int pos = (size-d%size);
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

        System.out.println(Arrays.toString(rotated));
    }
}
