public class SearchInArray {
    public static void main(String[] args) {
        int arr[] = {5, 9, 3, 4, 8, 4, 3, 10};
        int n = 8;
        System.out.println(largestElement(arr, n));
    }
    static int largestElement(int[] arr, int n) {
        // Write your code here.
        int start = 0;
        int end = n-1;
        System.out.println("End : "+end);
        int max = 0;
        System.out.println("Hello");
        while(start<end){
            if(arr[start]>=max){
                max = arr[start];
                start++;
            }
            else if(arr[end] >max){
                max = arr[end];
                end--;
            }
            else{
                start++;
                end--;
            }
        }
        return max;

    }
}
