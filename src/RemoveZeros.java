import java.util.Arrays;

public class RemoveZeros {
    public static void main(String[] args) {
        int arr[] = {0,1,0,3,12};
        moveZeroes(arr);
    }
    public static void moveZeroes(int[] nums) {
        int j = -1;
        for(int i = 0; i<nums.length; i++){
            System.out.println("nums["+i+"] = "+nums[i]);
            if(nums[i] == 0){
                j = i;
                break;
            }
        }
        System.out.println("First j : "+ j);

        for(int i = j+1; i<nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
