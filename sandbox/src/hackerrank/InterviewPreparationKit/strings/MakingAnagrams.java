package hackerrank.InterviewPreparationKit.strings;

//https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings

public class MakingAnagrams {
    private static final int NUM_LETTERS = 26; // we assume lower-case letters only

    static int makeAnagram(String a, String b) {
        /* For each string, create an array of the count of each character */
        int [] array1 = createCharHistogram(a);
        int [] array2 = createCharHistogram(b);

        /* Count number of deletions we need to make the Strings anagrams of each other */
        int deletions = 0;
        for (int i = 0; i < NUM_LETTERS; i++) {
            deletions += Math.abs(array1[i] - array2[i]);
        }
        return deletions;

    }

    /* Creates an array with the count of each character */

    private static int [] createCharHistogram(String str) {
        int [] array = new int[NUM_LETTERS];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            array[ch - 'a']++;
        }
        return array;
    }
    public static void main(String[] args) {
        System.out.println(makeAnagram("cde","abc"));
    }
}
