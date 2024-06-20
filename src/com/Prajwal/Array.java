package com.Prajwal;

public class Array {
    private static int[] search2DMAtrix(int[][] arr, int target) {
        int row = 0;
        int column = arr.length - 1;
        while(row < arr.length && column > 0){
            if(arr[row][column] == target) return new int[] {row, column};

            else if(arr[row][column] < target) row++;
            else column--;
        }
        return new int[]{-1, -1};
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

    private static int ceiling(int num[],int target) {
        int start = 0;
        int end = num.length-1;
        int mid;
        while(start<end){
            mid = start + (end - start)/2;
            if(target > num[mid]){
                start = mid+1;
            }
            else if(target <= num[mid]){
                // i am using "here" because we need to return the minimum index
                end = mid-1;
            }
            else
                return mid;
        }
        return start;
    }



    public static void rotate(int[] nums, int k) {

            //    public static void rotate(int[] nums, int k) {
            //        for(int i = 0; i<k; i++)
            //            nums = lRotateOnce(nums);
            //        System.out.println(Arrays.toString(nums));
            //
            //    }
            //    public static int[] lRotateOnce(int[] nums){
            //
            //        int temp = nums[nums.length-1];
            //        System.out.println("Temp : "+temp);
            //        int i;
            //
            //        for(i = nums.length-1; i > 0; i--){
            //            System.out.println(nums[i]);
            //            nums[i] = nums[i - 1];
            //            System.out.println(nums[i]);
            //        }
            //        nums[i] = temp;
            //        System.out.println(Arrays.toString(nums));
            //        return nums;
            //    }
        if(k < 0)
            k = k - nums.length;
        if(k >= nums.length)
            k = k%nums.length;
        nums = reverse(nums, 0, nums.length-k-1);
        System.out.println("Reverse 1: "+ java.util.Arrays.toString(nums));
        nums = reverse(nums, nums.length-k, nums.length-1);
        System.out.println("Reverse 2: "+ java.util.Arrays.toString(nums));
        nums = reverse(nums, 0, nums.length-1);
        System.out.println("Reverse 3: "+ java.util.Arrays.toString(nums));
    }
    public static int[] reverse(int[] nums, int start, int end){
        System.out.println("Start : "+start+" End : "+end);
        while(start<=end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }



    public static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid]>arr[mid+1])
                return mid;
            if(arr[mid]<arr[mid-1])
                return mid-1;
            if(arr[mid] < start)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
    public static int findDuplicatePivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid]>arr[mid+1])
                return mid;
            if(arr[mid]<arr[mid-1])
                return mid-1;
            if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                if(arr[start]>arr[start+1])
                    return start;
                start++;
                if(arr[end]<arr[end - 1])
                    return end - 1;
                end--;
            }
            else if(arr[start] < arr[mid]||(arr[start] == arr[mid] && arr[mid] > arr[end])){
                start = mid + 1;
            }else end = mid - 1;
        }
        return -1;

    //    private static int findPivot(int[] arr) {
    //        int start = 0;
    //        int end = arr.length - 1;
    //        while(start <= end){
    //            int mid = start + (end-start)/2;
    //
    //            if(arr[mid]>arr[mid+1])
    //                return mid;
    //            if(arr[mid]<arr[mid-1])
    //                return mid-1;
    //
    //            if(arr[mid] > start)
    //                end = mid - 1;
    //            else
    //                start = mid + 1;
    //        }
    }
}

