package hackerrank.InterviewPreparationKit.strings;
//https://www.hackerrank.com/challenges/special-palindrome-again/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
import java.util.*;

public class SpecialStringAgain {


    static long substrCount(int n, String s) {
        List<String> res = new ArrayList<>();
//        char[] arr = s.toCharArray();
//        for (int i = 0; i < arr.length; i++) {
//
//            res.add(new String(arr[i]));
//        }

        for (int i = 0; i < s.length(); i++) {
            
            String curr = s.substring(i, i+1);
            
            res.add(curr);
            
            for (int greedy = i+1; greedy < s.length(); greedy++) {
                if(s.substring(greedy, greedy+1).equals(curr)){
                    res.add(s.substring(i,greedy+1));
                }    else {
                    break;
                }
            }
            int j=i-1, k=i+1;
            while(j>=0 && k<s.length()) {
                if(isPalindrome(s.substring(j,k+1))){
                    res.add(s.substring(j,k+1));
                } else {
                    break;
                }
                j--;
                k++;
            }
        }
        System.out.println("res = " + res);
        return res.size();

    }
    private static boolean isPalindrome(String input) {
        StringBuilder plain = new StringBuilder(input);
        StringBuilder reverse = plain.reverse();
        return (reverse.toString()).equals(input);
    }

    public static void main(String[] args) {
        String input = "asasd";
        //System.out.println(substrCount(input.length(), input));

        input = "abcbaba"; //11
        System.out.println(substrCount(input.length(), input));
    }
}
