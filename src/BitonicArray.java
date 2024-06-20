// BITONIC ARRAY  is an array in which first part of the array is ASCENDING and second part of the array is NEGATIVE
public class BitonicArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 3, 2, 1};
        System.out.println(arr[peakElementInMountainArray(arr)]);
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
        return end;
    }
}
