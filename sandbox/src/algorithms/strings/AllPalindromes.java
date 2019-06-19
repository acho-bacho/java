package algorithms.strings;

import java.util.*;

// https://www.geeksforgeeks.org/given-a-string-print-all-possible-palindromic-partition/


public class AllPalindromes {

    public static void main(String[] args) {

        String input = "nitin";

        System.out.println("All possible palindrome partions for " + input + " are :");

        allPalPartitions(input);


        Set<String> res = findAllPalindromesUsingBruteForceApproach(input);
        for (String str : res) {
            System.out.println(str);
        }

    }

    public static void allPalPartitions(String in) {

    }


    // https://www.baeldung.com/java-palindrome-substrings
    public static Set<String> findAllPalindromesUsingBruteForceApproach(String input) {

        Set<String> palindromes = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {

            for (int j = i + 1; j <= input.length(); j++) {

                if (isPalindrome(input.substring(i, j))) {
                    palindromes.add(input.substring(i, j));
                }
            }
        }

        return palindromes;
    }

    private static boolean isPalindrome(String input) {
        StringBuilder plain = new StringBuilder(input);
        StringBuilder reverse = plain.reverse();
        return (reverse.toString()).equals(input);
    }
}
