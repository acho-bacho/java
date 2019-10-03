package hackerrank.CrackingTheCodingInterview.hashTables;

import java.util.HashMap;

public class IceCream {

    public static void buyIceCream(int [] costs, int money) {
        HashMap<Integer, Integer> map = new HashMap<>(); // key = cost, value = ice cream ID
        for (int i = 0; i < costs.length; i++) {
            int icecreamID = i + 1;
            int cost       = costs[i];

            /* Find 2 flavors to buy that sum to "money" */
            int otherCost  = money - cost;
            if (map.containsKey(otherCost)) {
                // otherCost ID + this ID
                System.out.println(map.get(otherCost) + " " + icecreamID);
            }

            map.putIfAbsent(cost, icecreamID);
        }
    }


    public static void main(String[] args) {
        int[] costs = {1, 4, 5, 3, 2};
        int m = 4;
        buyIceCream(costs, m);
    }
}
