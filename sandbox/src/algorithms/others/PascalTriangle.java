package algorithms.others;

import java.util.ArrayList;
import java.util.Arrays;

public class PascalTriangle {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> result = build(3);
        //ArrayList<ArrayList<Integer> > result = {{1,3}, {4,5}};

        for (ArrayList<Integer> al :
                result) {
            System.out.println(al);
        }
    }

    static ArrayList<ArrayList<Integer>> build(int depth) {


        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(depth);
        for (int i = 0; i < depth; i++) {
            ArrayList<Integer> line = new ArrayList<Integer>(depth);
            for (int j = 0; j < depth; j++)
                line.add(null);
            result.add(line);
        }

        System.out.println("size " + result.size());


        for (int h = 0; h < depth; h++) {
            ArrayList<Integer> line = result.get(h);
            ArrayList<Integer> prevLine = result.get(h - 1);
            System.out.println("line is " + line);

            for (int x = 0; x < depth; x++) {
                System.out.println("x " + x);
                System.out.println("h " + h);
                if (x == 0 || x == h) {
                    line.set(x, 1);
                    System.out.println("set value ");
                    continue;
                }

                //line.set(x, 88);
            }
        }
/*
        for (int h = 0; h < depth; h++) {

            ArrayList<Integer> line = result.get(h);
            System.out.println("get line ");
            System.out.println("line is " + line);
            System.out.println("line size " + line.size());
            for (int i = 0; i < line.size(); i++) {
                //if (i == 0 || i == h - 1) {
                    line.set(i, 1);
                System.out.println("set value ");
                 //   continue;
               // }
            }
        }
*/
        return result;
    }
}
