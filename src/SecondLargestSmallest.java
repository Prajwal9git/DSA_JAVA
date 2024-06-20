import java.util.*;
public class SecondLargestSmallest {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int len = 10;
        int result[] = new int[2];
        result = getSecondOrderElements(len, arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.

        int max = a[0];//Integer.MIN_VALUE;
        int second_max = a[0];//Integer.MIN_VALUE;
        int min = a[0];//Integer.MAX_VALUE;
        int second_min = a[0];//Integer.MAX_VALUE;

        for(int i = 0; i<n; i++){
            if(a[i] > max){
                second_max = max;
                max = a[i];
            }
            else if(a[i] > second_max && a[i] != max)
                second_max = a[i];

            if(a[i] < min){
                second_min = min;
                min = a[i];
            }
            else if(a[i] < second_min && a[i] != min)
                second_min = a[i];

        }
        int arr[] = {second_max, second_min};
        return arr;
    }
}
