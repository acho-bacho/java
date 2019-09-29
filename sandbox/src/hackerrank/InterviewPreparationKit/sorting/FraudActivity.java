package hackerrank.InterviewPreparationKit.sorting;

import java.util.Arrays;

public class FraudActivity {

    static int activityNotifications(int[] expenditure, int d) {
        int notifications = 0;

        if (d < expenditure.length) {
            for (int i = d; i < expenditure.length ; i++) {
                float median = median(expenditure, i-d, i);

                if(expenditure[i]>=2*median){
                    notifications++;
                }
            }
        }

        return notifications;
    }
    // [start....end)
    private static float median(int[] arr, int start, int end) {
        //int[] newArr = Arrays.copyOfRange(arr, start, end);
        //Arrays.sort(newArr);
        Arrays.sort(arr, start, end);
        if((end-start)%2==0) {
            //even number of elements
            //median is avg of median
            int a = arr[(end-start)/2];
            int b = arr[(end-start)/2 -1];
            return (a+b)/2F;
        }
        else{
            //odd
            //median is middle
            return arr[(end-start)/2];
        }
    }

    public static void main(String[] args) {
        System.out.println(activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5));
        System.out.println(activityNotifications(new int[]{1, 2, 3, 4, 4}, 4));
    }
}
