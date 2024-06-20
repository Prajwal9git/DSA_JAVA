public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int arr[] = {1,0,1,1,0,1};
        int count = findMaxConsecutiveOnes(arr);
        System.out.println(count);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        if(nums.length == 1)
            if(nums[0] == 0)
                return 0;
        for(int i = 0; i<nums.length - 1; i++){
            if(nums[i] == 1 && nums[i+1] != 1) {
                System.out.println("No count : "+i);
                if (count > max) {
                    max = count;
                }
                count = 0;
            }
            else{
                System.out.println("count : "+i);
                count += 1;
                System.out.println("count : " + count);
            }
        }
        if(count > max)
            max = count;
        System.out.println("Max : "+max);
        return max+1;
    }
}
