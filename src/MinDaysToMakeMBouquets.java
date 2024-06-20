public class MinDaysToMakeMBouquets {
    public static void main(String[] args) {
        int arr[] = {1,10,3,10,2};
        int m = 3;
        int k = 1;
        System.out.println(minDays(arr,m, k));
    }

    private static int minDays(int[]bloomDay, int m, int k) {

        long val = m*k;
        int n = bloomDay.length;
        System.out.println( "m*k : "+val+" bloomDay : "+n);
        if(n < val)
            return -1;

        int maxmin[] = new int[2];
        maxmin = maxE(bloomDay);
        int low = maxmin[1];
        int high = maxmin[0];
        int mid;
        while(low<high){
            mid = low + (high - low)/2;
            if(possible(bloomDay, mid, m, k)){
                high = mid;
            }
            else low = mid+1;
        }
        return low;
    }

    private static boolean possible(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int bouq = 0;
        for(int i = 0; i<bloomDay.length; i++){
            if(bloomDay[i] <= day){
                count++;
            }
            else{
                bouq += count/k;
                count = 0;
            }
        }
        bouq += count/k;
        return bouq>=m;
    }

    private static int[] maxE(int[] array) {
        int minmax[] = {array[0], array[0]};
        for(int i = 1; i<array.length; i++){
            if(array[i] >= minmax[0])
                minmax[0] = array[i];
            if(array[i] <= minmax[1])
                minmax[1] = array[i];
        }

        return minmax;
    }
}
