package hackerrank.CrackingTheCodingInterview;

public class Primality {

    static String primality(int n) {
        if(n<2){
            return "Not prime";
        } else if(n==2) {
            return "Prime";
        } else if(n%2==0){
            return "Not prime";
        }

        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) { // skips even numbers for faster results
            if (n % i == 0) {
                return "Not prime";
            }
        }
        return "Prime";
    }

    public static void main(String[] args) {

        System.out.println(primality(25));
        System.out.println(primality(12));
        System.out.println(primality(5));
        System.out.println(primality(7));

    }
}
