public class SearchInRotatedArray {
    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};
        int target = 0;
        int pivot = searchPivot(nums);
        System.out.println("Rotation at : "+(pivot+1));
        System.out.println("Pivot : "+pivot);
        int pos = searchPos(nums, 0, pivot, target);

        if(pos == -1)
            pos = searchPos(nums, pivot + 1, nums.length - 1, target);
        System.out.println("Position of Target : "+pos);
    }

    private static int searchPos(int[] nums, int start, int end, int target) {
        while(start<=end){

            int mid =  start + (end - start)/2;



            if(target == nums[mid]) {

                return mid;
            }

            else if(nums[mid]>target) end = mid -1;
            else if(nums[mid]<target) start = mid + 1;
        }

        return -1;
    }

    private static int searchPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start<end){
            int mid = start + (end -start)/2;
            if((mid < end) && (nums[mid]>nums[mid+1])) return mid;
            if((mid > start) && (nums[mid]<nums[mid-1])) return mid - 1;

            if(nums[mid] >= nums[start]) start = mid+1;
            else end = mid -1;
        }
        return -1;
    }
}
