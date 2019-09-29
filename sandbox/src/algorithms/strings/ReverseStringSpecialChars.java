package algorithms.strings;

//https://www.geeksforgeeks.org/reverse-an-array-without-affecting-special-characters/

//Input:   str = "a,b$c"
//Output:  str = "c,b$a"
//Note that $ and , are not moved anywhere.
//Only subsequence "abc" is reversed
//Input:   str = "Ab,c,de!$"
//Output:  str = "ed,c,bA!$"

public class ReverseStringSpecialChars {

    public static void main(String[] args) {

        String input = "Ab,c,de!$";

        System.out.println(reverse(input));
    }

    static String reverse(String input) {

        char[] inpArr = input.toCharArray();
        char[] result = input.toCharArray();

        int l = 0, r = inpArr.length - 1;

        while (l < r) {

            if (Character.isAlphabetic(inpArr[l])) {
                //change it
                if (Character.isAlphabetic(inpArr[r])) {
                    result[l] = inpArr[r];
                    result[r] = inpArr[l];
                    l++;
                    r--;
                } else {
                    r--;
                }
            } else {
                l++;
            }
        }

        return new String(result);
    }
}
