import static java.lang.Math.ceil;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int arr[] = {30,11,23,4,20};
        int h = 5;
        int max = findMAx(arr);
        System.out.println(optK(arr, max, h));
    }

    private static int optK(int[] arr, int max, int h) {
        int low = 1;
        int high = max;
        int mid;
        while(low<=high){
            mid = low + (high - low)/2;
            if(reqTime(arr, mid) <= h){
                high = mid - 1;
            }else low = mid+1;
        }
        return low;
    }

    private static int reqTime(int[] arr, int k) {
        int reqTime = 0;
        for(int i = 0; i < arr.length; i++){
            reqTime+= Math.ceil((double)(arr[i])/(double)k);
        }
        return reqTime;
    }

    private static int findMAx(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= max) {
                max = arr[i];
            }
        }
        return max;
    }
}