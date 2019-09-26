package hackerrank;

//https://www.programcreek.com/2014/02/leetcode-combination-sum-java/

import java.util.*;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        helper(candidates, 0, target, 0, temp, result);

        return result;
    }

    private void helper(int[] candidates, int start, int target, int sum, List<Integer> tmpList, List<List<Integer>> result) {

        if (sum > target) {
            //could not reach target
            return;
        }

        if (sum == target) {
            result.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            tmpList.add(candidates[i]);
            helper(candidates, i, target, sum + candidates[i], tmpList, result);
            tmpList.remove(tmpList.size() - 1);
        }
    }


    public static void main(String[] args) {
        //int[] candidates = {1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};
        //int target = 25;
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = new CombinationSum().combinationSum(candidates, target);
        Collections.sort(res, new CustomComparator());
        System.out.println(res.size());
        System.out.println("res = " + res);

    }
}

class CustomComparator implements Comparator<List> {
    @Override
    public int compare(List l1, List l2) {
        return l1.size() - l2.size();
    }
}
