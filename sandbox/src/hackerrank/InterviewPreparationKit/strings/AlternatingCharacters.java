package hackerrank.InterviewPreparationKit.strings;

public class AlternatingCharacters {



    static int alternatingCharacters(String str) {
        int deletions = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i-1)) {
                deletions++;
            }
        }
        return deletions;
    }

    public static void main(String[] args) {
        System.out.println(alternatingCharacters("AAABBB"));
    }
}
