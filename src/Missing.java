import java.util.Arrays;

public class Missing{
    public static void main(String[] args) {
        int nums[] = {1};
        int n = missingNumber(nums);
        System.out.println("Missing Number : "+n);
    }

    public static int missingNumber(int[] nums) {
        int arr[] = new int[nums.length + 1];
        Arrays.fill(arr, -1);
        for(int i = 0; i<nums.length; i++){
            arr[nums[i]] = nums[i];
        }
        for(int i = 0; i<=nums.length; i++){
            if(arr[i] != i){
                System.out.println("hi");
                return i;
            }
        }
        return -1;

    }

//    public static int missingNumber(int[] nums) {
//        int arr[] = new int[nums.length];
//        for(int i = 0; i<nums.length; i++){
//            if(nums[i] >= nums.length)
//                continue;
//            arr[nums[i]] = nums[i];
//        }
//        for(int i = 0; i<nums.length; i++){
//            if(arr[i] != i)
//                return i;
//        }
//        return -1;
//
//    }
}
