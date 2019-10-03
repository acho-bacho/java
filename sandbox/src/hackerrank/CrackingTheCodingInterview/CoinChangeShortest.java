package hackerrank.CrackingTheCodingInterview;

import java.util.Arrays;
import java.util.Collections;

//Solution https://www.algoskills.com/g_coinchange.php

public class CoinChangeShortest {

    ////greedy way of solving
    public static void minCoinsGreedy(Integer[] coins, int amount) {

        //big coins come first
        Arrays.sort(coins, Collections.reverseOrder());

        for (int i = 0; i < coins.length; i++) {
            while (amount >= coins[i]) {
                //while loop is needed since one coin can be used multiple times
                amount = amount - coins[i];
                System.out.print(coins[i] + " ");
            }
            System.out.print("\n");
        }
    }

    public static int minCoinsDP(Integer[] coins, int amount) {
        int[] result = new int[amount + 1];
        result[0] = 0;

        for (int amountPtr = 1; amountPtr < result.length; amountPtr++) {
            result[amountPtr] = Integer.MAX_VALUE;

            for (int i = 0; i < coins.length; i++) {
                if (amountPtr >= coins[i]) {
                    result[amountPtr] = Math.min(result[amountPtr - coins[i]] + 1, result[amountPtr]);
                }
            }
        }
        return result[amount];
    }

    public static void main(String[] args) {
        Integer[] coins = {1, 2, 5, 10, 50};
        int amount = 27;
        minCoinsGreedy(coins, amount);
        System.out.println("min coins dp " + minCoinsDP(coins, amount));
    }
}
