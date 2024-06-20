public class IsArraySorted {
    public static void main(String[] args) {
        int nums[] = {6, 10, 6};
        boolean isArrSorted = check(nums);
        System.out.println(isArrSorted);
    }

    public static boolean check(int[] nums) {
        int count = 0;
        boolean sorted = false;
        boolean rsorted = false;
        if(nums[0] <= nums[nums.length - 1]){
            sorted = true;
        }
        if(nums[0] >= nums[nums.length - 1]){
            rsorted = true;

            if(sorted == true || rsorted == true)
            for(int i = 0; i<nums.length -1; i++)
                if(nums[i] > nums[i+1])
                    count+=1;
        }
        if(sorted == true && count == 0)
            return true;
        else if(rsorted == true && count == 1)
            return true;

        return false;
    }
}
