package hackerrank.CrackingTheCodingInterview.BitManipulation;


//https://www.hackerrank.com/challenges/ctci-lonely-integer/problem

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LonelyInteger {


    static int myStupidSolutionfindLonely(List<Integer> arr) {

        if (arr.size() == 0) {
            return -1;
        } else if (arr.size() == 1) {
            return arr.get(0);
        }

        Collections.sort(arr);

        for (int i = 0; i < arr.size(); ) {
            if(i==arr.size()-1 || arr.get(i)!=arr.get(i+1)) {
                return arr.get(i);
            }
            i+=2;
        }

        return -1;
    }


    // O(n) runtime. O(1) space. Uses XOR. Keep in mind:
    //   1) x ^ x = 0
    //   2) x ^ 0 = x
    //   3) XOR is commutative and associative

    static int findLonely(List<Integer> array) {
        int val = 0;
        System.out.println(array);
        for (int num : array) {
            System.out.println("before. val = " + val);
            System.out.println(String.format("%d ^ %d = %d", val, num ,val ^ num));
            val = val ^ num; // ^ is XOR operator
            System.out.println("after. val = " + val);
            System.out.println("=======");
        }
        return val;
    }


    public static void main(String[] args) {
        System.out.println(myStupidSolutionfindLonely(Arrays.asList(1, 1, 2, 3, 2)));
        System.out.println(findLonely(Arrays.asList(3, 1, 1, 2, 2)));
    }
}
