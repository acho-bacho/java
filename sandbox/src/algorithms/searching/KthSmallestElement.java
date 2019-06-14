package algorithms.searching;

// https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/
// O(n)
//Input: arr[] = {7, 10, 4, 3, 20, 15}
//       k = 3
//Output: 7
public class KthSmallestElement {
    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15};

        findSmallest(arr, 3);
    }

    static void findSmallest(int[] arr, int k) {

        if(k>arr.length){
            System.out.println("k is larger than array");
            return;
        }

        int[] smallestArr = new int[k];
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            while()
        }

    }
}
