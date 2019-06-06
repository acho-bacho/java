package algorithms.others;

import java.util.ArrayList;

public class PascalTriangle {
    public static void main(String[] args) {

        int[][] resultArray = buildArray(8);
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray.length; j++) {
                System.out.print(resultArray[i][j] + " ");
            }
            System.out.println();
        }

        ArrayList<ArrayList<Integer>> result = build(8);

        for (ArrayList<Integer> al :
                result) {
            System.out.println(al);
        }
    }

    static int[][] buildArray(int depth) {

        int[][] result = new int[depth][depth];

        for (int h = 0; h < depth; h++) {

            int[] line = result[h];

            for (int x = 0; x < h + 1; x++) {

                if (x == 0 || x == h) {
                    line[x] = 1;
                    continue;
                }
                if (h > 0) {
                    int[] prevLine = result[h - 1];
                    line[x] = prevLine[x] + prevLine[x - 1];
                }
            }
        }
        return result;
    }


    // same but with arrayList
    static ArrayList<ArrayList<Integer>> build(int depth) {
        // populate the arrayList
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(depth);
        for (int i = 0; i < depth; i++) {
            ArrayList<Integer> line = new ArrayList<Integer>(depth);
            for (int j = 0; j < depth; j++) {
                line.add(null);
            }
            result.add(line);
        }

        for (int h = 0; h < depth; h++) {

            ArrayList<Integer> line = result.get(h);

            for (int x = 0; x < h + 1; x++) {

                if (x == 0 || x == h) {
                    line.set(x, 1);
                    continue;
                }
                if (h > 0) {
                    ArrayList<Integer> prevLine = result.get(h - 1);
                    line.set(x, prevLine.get(x) + prevLine.get(x - 1));
                }
            }
        }
        return result;
    }

}
