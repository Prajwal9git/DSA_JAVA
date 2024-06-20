import java.util.Arrays;

public class FloorCeil {
    public static void main(String[] args) {
        int arr[] = {6, 6, 7, 12, 16, 18, 19, 22, 23, 30 };
        System.out.println(Arrays.toString(getFloorAndCeil(arr, 10, 14)));
    }

    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        // Wriute your code here.
        int arr[] = {-1, -1};
        arr[0] = floor(a, n, x);
        arr[1] = ceiling(a, n, x);
        return arr;
    }

    public static int floor(int[] a, int n, int x){
        int start = 0;
        int end = n - 1;

        int mid;

        while(start <= end){
            mid = start + (end - start)/2;
            if(x < a[mid]) end = mid - 1;
            else start = mid + 1;

            // else return mid;
        }

        if(a[start] < x || a[start] == x) return a[start];

        return -1;
    }

    public static int ceiling(int[] a, int n, int x){
        int start = 0;
        int end = n - 1;

        int mid;

        while(start <= end){
            mid = start + (end - start)/2;
            if(x > a[mid]) start = mid + 1;
            else end = mid - 1;

            // else return mid;
        }

        if(a[start] > x || a[start] == x) return a[start];

        return -1;
    }
}
