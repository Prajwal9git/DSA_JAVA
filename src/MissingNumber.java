public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < n){
            int correct = nums[i];
            if(nums[i] < n && nums[i] != nums[correct]){
                int temp = nums[correct];
                nums[correct] = nums[i];
                nums[i] = temp;
            }
            else i++;
        }

        for(int j = 0; j < n; j++){
            if(nums[j] != j) return j;
        }

        return n;
    }
}
