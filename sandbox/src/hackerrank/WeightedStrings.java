package hackerrank;

import java.util.Arrays;

public class WeightedStrings {

    public static String smallestString(long weight) {
        String answer = "";


        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        long[] weights = new long[alphabet.length];
        //А 1
        //B 2*A + A
        //C 3*B + B
        //D 4*C + C

        weights[0] = 1;

        for (int i = 1; i < weights.length; i++) {
            // How to check for Long overflow ??  Long.MAX_VALUE
            weights[i] = (long) (i + 2) * weights[i - 1];
        }
        final long MICROS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        System.out.println((long) MICROS_PER_DAY / (long) MILLIS_PER_DAY);
        System.out.println();

        System.out.println(alphabet);
        System.out.println(Arrays.toString(weights));
        return answer;
    }

    public static void main(String[] args) {

        smallestString(25);

        //System.out.println(test);
    }
}
