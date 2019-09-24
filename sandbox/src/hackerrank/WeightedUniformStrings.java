package hackerrank;

import java.util.*;

public class WeightedUniformStrings {

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {
        String[] result = new String[queries.length];

        String strAlphabet = "abcdefghijklmnopqrstuvwxyz";

        //char[] alphabet = strAlphabet.toCharArray();
        //int[] weights = new int[alphabet.length];
        //System.out.println(Arrays.toString(alphabet));
        //System.out.println(Arrays.toString(weights));

        //for (int i = 0; i < alphabet.length ; i++) {
        //    char curr = alphabet[i];
        //    //System.out.println(curr + " " + (curr - 'a' + 1));
        //}


        HashSet<Integer> weights = getWieghts(s);

        for (int i = 0; i < queries.length; i++) {
            result[i] = weights.contains(queries[i]) ? "Yes" : "No";
        }

        return result;
    }

    private static HashSet<Integer> getWieghts(String s) {
        HashSet<Integer> result = new HashSet<Integer>();
        int size = s.length();
        char prev = ' ';

        char curr;
        int currStart = 0;
        for (int i = 0; i < size; i++) {
            curr = s.charAt(i);

            if (curr != prev) {
                // add prev
                System.out.println(s.substring(currStart, i));
                result.add((prev - 'a' + 1) * (i - currStart));

                //start new uniform
                currStart = i;
            }
            prev = curr;
        }
        //add last
        System.out.println(s.substring(currStart));
        result.add((prev - 'a' + 1) * (size - currStart));

        return result;
    }

    public static void main(String[] args) {

        String s = "aaabbbbcccddd";
        int[] queries = {5, 9, 7, 8, 12, 5};

        String[] result = weightedUniformStrings(s, queries);
        System.out.println(Arrays.toString(result));

    }
}
