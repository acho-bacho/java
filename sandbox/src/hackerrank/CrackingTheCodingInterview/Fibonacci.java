package hackerrank.CrackingTheCodingInterview;

public class Fibonacci {

    public static long fib(int i) {
        if(i<0)
            return -1;

        if (i == 0) {
            return 0;
        } else if(i==1) {
            return 1;
        } else {
            return fib(i-1)+fib(i-2);
        }
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}
