package hackerrank.InterviewPreparationKit.sorting;

import java.util.Arrays;

public class MarkAndToys {
    static int maximumToys(int[] prices, int k) {

        Arrays.sort(prices);
        int numToys = 0;

        for (int i = 0; i < prices.length; i++) {
            k -= prices[i];
            if(k>=0){
                numToys++;
            }
        }

        return numToys;
    }

    public static void main(String[] args) {
        System.out.println(maximumToys(new int[]{1, 12, 5, 111, 200, 1000, 10}, 50));
    }
}
