package hackerrank.CrackingTheCodingInterview;

import java.util.ArrayList;
import java.util.List;

//ways to make change for an amount

//solution https://www.youtube.com/watch?v=jaNZ83Q3QGc
public class CoinChange {

    //dynamic programmin approach
    static int ways(int n, int[] coins) {
        //index of array is the amount
        int[] combinations = new int[n + 1];
        combinations[0] = 1;

        for (int coin : coins) {
            //get all combinations for coin for amount
            for (int amount = 1; amount < combinations.length; amount++) {
                //THIS IS THE FORMULA
                if (amount >= coin) {
                    combinations[amount] += combinations[amount - coin];
                }
            }
        }
        return combinations[n];
    }

    static int waysRecursive(int amount, int[] coins) {
        return waysRecursiveHelper(amount, coins, 0);
    }
    //current coin keeps track of the coin we reached, so that no duplicate combinations occur
    static int waysRecursiveHelper(int amount, int[] coins, int currentCoin) {

        if (amount == 0) {
            return 1;
        }
        if (amount < 0) {
            return 0;
        }

        int numCombos = 0;
        for (int coin = currentCoin; coin < coins.length; coin++) {
            numCombos += waysRecursiveHelper(amount-coins[coin], coins, coin);
        }

        return numCombos;
    }


    //CombinationSum.java like solution
    public static List<List<Integer>> combinationSum(int[] coins, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        helper(coins, 0, target, 0, temp, result);

        return result;
    }

    private static  void helper(int[] coins, int start, int target, int sum, List<Integer> tmpList, List<List<Integer>> result) {

        if (sum > target) {
            //could not reach target
            return;
        }

        if (sum == target) {
            result.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = start; i < coins.length; i++) {
            tmpList.add(coins[i]);
            helper(coins, i, target, sum + coins[i], tmpList, result);
            tmpList.remove(tmpList.size() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(ways(10, new int[]{2, 5, 3, 6}));
        System.out.println(waysRecursive(10, new int[]{2, 5, 3, 6}));
        System.out.println(combinationSum(new int[]{2, 1}, 4));
    }
}
