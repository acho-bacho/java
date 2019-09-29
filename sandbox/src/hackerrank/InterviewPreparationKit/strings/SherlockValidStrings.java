package hackerrank.InterviewPreparationKit.strings;

import java.util.*;

public class SherlockValidStrings {

    private static final int NUM_LETTERS = 26; // we assume lower-case letters only

    static String isValid(String s) {
        return test(s.toCharArray()) ? "YES" : "NO";
    }
    static boolean test(char[] S) {
        //If string contains less than two letters
        if (S.length < 2) {
            return true;
        }

        //Create histogram of letters
        final int[] histogram = new int[26];

        for (int i = 0; i < S.length; i++) {
            histogram[S[i] - 'a']++;
        }
        //same as for (int i = 0, N = S.length; i < N; ++histogram[S[i++] - 'a']) { }

        //Sort the histogram
        Arrays.sort(histogram);

        //Ignore unseen letters -> move cursor i to first non-zero
        int i;
        for (i = 0; i < 26 && histogram[i] == 0; ++i) {
        }

        //If all letter frequencies are equal
        //0000000000000000000002222222222222222222222222
        if (histogram[i] == histogram[25]) {
            return true;
        }

        //If there's one letter above the rest by ONE
        //0000000000000000000000222222222222222222222223
        if (histogram[25] > histogram[24]) {
            return histogram[i] == histogram[24] && histogram[25] - histogram[24] == 1;
        }

        //If there's one letter below the rest by one or that can be removed
        //0000000000000000000001222222222222222222222222
        return histogram[i] < histogram[i + 1] && histogram[i + 1] == histogram[25] && histogram[i] == 1;
    }

    public static void main(String[] args) {
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));
    }
}
