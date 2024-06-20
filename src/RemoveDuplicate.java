import java.util.*;
public class RemoveDuplicate {
    public static void main(String[] args) {
        int arr[] = {1, 2, 0};
        int k = removeDuplicates(arr);
        System.out.println("Unique : "+k);
    }
    public static int removeDuplicates(int[] nums) {
        int b[] = new int[nums.length];
        int k = 0;
        int i;
        for(i = 0; i<nums.length - 1; i++){
            if(nums[i] == nums[i+1]){
                i += 1;
            }

            if(nums[i] != nums[i+1]) {
                b[k] = nums[i];
                k+=1;
            }
        }
        b[k] = nums[i];
        System.out.println("Array : "+Arrays.toString(b));
        for(i = 0; i <= k; i++)
            nums[i] = b[i];
        for(i = k+1; i <nums.length; i++)
            nums[i] = 0;
        System.out.println("Array : "+Arrays.toString(nums));
        return k+1;
    }
}
