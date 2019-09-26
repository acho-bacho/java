package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;

public class WeightedStrings {
    char[] alphabet = "ABCDEFGHIJ".toCharArray();
    long[] weights = new long[alphabet.length];

    public String smallestString(long weight) {
        String answer = "";

        //char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        //char[] alphabet = "ABCDEFGHIJ".toCharArray();
        //long[] weights = new long[alphabet.length];
        //А 1
        //B 2*A
        //C 3*B
        //D 4*C
        // ...or something like that
        weights[0] = 1;

        for (int i = 1; i < weights.length; i++) {
            // How to check for Long overflow ??  Long.MAX_VALUE
            weights[i] = (long) (i + 1) * weights[i - 1];
        }



        System.out.println(Arrays.toString(alphabet));
        System.out.println(Arrays.toString(weights));

        ArrayList<String> allStrings = find(weight);

        System.out.println("RESULT");
        System.out.println(allStrings);
        return answer;
    }

    private ArrayList<String> find(long weight) {
        ArrayList<String> allResults = new ArrayList<String>();
        for (int i = weights.length-1; i >= 0; i--) {
            findHelper(weight,0, weights.length-1);

        }

        return allResults;

    }

    private ArrayList<String> findHelper(long weight, int start, int end) {

        ArrayList<String> allResults = new ArrayList<String>();

        for (int i = end; i >= start; i--) {
            if(weights[i] == weight){
                ArrayList<String> result = new ArrayList<String>();
                result.add(String.valueOf(alphabet[i]));
                return result;
            } else if(weights[i] < weight){
                //start here
                int repeat = (int) (weight/weights[i]);
                System.out.println(repeat + " * " + alphabet[i]);
                System.out.println("weights[i] = " + weights[i] + ", start = " + start + ", end = " + end);

                ArrayList<String> result = findHelper(weight-weights[i]*repeat, start,i);
                if(result!=null) {
                    String toAdd = String.valueOf(alphabet[i]).repeat(repeat);
                    for (int j = 0; j < result.size(); j++) {
                        result.set(j, toAdd+result.get(j));
                    }

                    return result;
                }
            }
        }
        return allResults;
    }




    public static void main(String[] args) {
        WeightedStrings a = new WeightedStrings();
        a.smallestString(25);

        //System.out.println(test);
    }
}
