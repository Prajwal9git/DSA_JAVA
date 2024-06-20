public class ElementInInfiniteArray {
    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 12, 15, 19, 20, 21, 24, 30, 31, 34, 35, 39, 45, 47, 57 };
        int target = 19;
        int pos = eleArr(arr, target);
        System.out.println(pos);
    }

    private static int eleArr(int[] arr, int target) {
        int start = 0;
        int end = 1;
        int result = -1;
        while(true){
            if(target > arr[end]){
                start = end + 1;
                end = start + (end - start + 1)*2;
            }
            else{
                int mid;
                while(start <= end){
                    mid = start + (end - start)/2;
                    if(target > arr[mid])
                        start = mid + 1;
                    else if(target < arr[mid])
                        end = mid - 1;
                    else {
                        result = mid;
                        break;
                    }
                }
                break;
            }
        }
        return result;
    }
}
