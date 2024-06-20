import java.util.Arrays;

import static java.util.Collections.swap;

public class SelectionSort {


    public static void main(String[] args) {
        int arr[] = {5, 24, 12, 3, 9, 4};
        int result[] = new int[arr.length];
        selectionSort(arr);
    }

    private static void selectionSort(int[] arr) {
        int i = 0;
        while(i < arr.length){
            int start = i;
            int end = arr.length - 1;
            int max = maxEle(arr, start, end);
            System.out.println(arr[max]);
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
            i = i+1;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static int maxEle(int[] arr, int start, int end) {
        int max = start;
        for(int i = start; i <= end; i++){
            if(arr[i] >= arr[max])
                max = i;
        }
        return max;
    }
}