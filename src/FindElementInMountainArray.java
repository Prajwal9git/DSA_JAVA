import java.util.Arrays;

public class FindElementInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 3, 2, 1};
        System.out.println("Arr : "+ Arrays.toString(arr));
        int target = 4;
        System.out.println("Target : "+target);
        int peak = peakElementInMountainArray(arr);
        int ans = binSearch(arr, peak, target, true);
        if(ans == -1)
            ans = binSearch(arr, peak, target, false);
        System.out.println("Element pos : "+ ans);

    }
    private static int peakElementInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while(start < end){
            mid = start + (end - start)/2;
            if(arr[mid] > arr[mid + 1])
                end = mid;
            else start = mid + 1;
        }
        System.out.println("Peak : "+end);
        return end;
    }


    private static int binSearch(int[] arr, int peak, int target, boolean found) {
        if(found == true) {
            int start = 0;
            int end = peak;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (target > arr[mid]) start = mid + 1;
                else if (target < arr[mid]) end = mid - 1;
                else return mid;
            }
            return -1;
        }
        else{
            int start = peak + 1;
            int end = arr.length - 1;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (target > arr[mid]) start = mid + 1;
                else if (target < arr[mid]) end = mid - 1;
                else return mid;
            }
            return -1;
        }
    }


}
