package hackerrank.CrackingTheCodingInterview;

//https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem

public class DavisStaircase {
    //cache 1:1,2:2,3:4
    static final int[] staircaseVals = {0, 1, 2, 4};
    static int stepPerms(int n) {
        //
        if (n < 1) {
            return 0;
        } else if (n<4) {
            return staircaseVals[n];
        }


        return stepPerms(n - 1) + stepPerms(n - 2) + stepPerms(n - 3);

    }

    public static void main(String[] args) {
        System.out.println(stepPerms(3));
    }
}
