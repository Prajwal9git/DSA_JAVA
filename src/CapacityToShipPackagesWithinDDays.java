public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 1;
        System.out.println(shipWithinDays(weights, days));
    }

    private static int shipWithinDays(int[] weights, int days) {
        int low = minCapacity(weights);
        System.out.println(low);
        int high = maxCapacity(weights);
        System.out.println(high);
        int mid;
        while(low <= high){
            mid = low + (high - low)/2;
            if(count(weights, mid) > days)
                low = mid+1;
            else high = mid - 1;
        }
        return low;
    }

    private static int count(int[] weights, int capacity) {
        int counts = 0;
        int sum = 0;
        for(int i = 0; i<weights.length; i++){

            sum += weights[i];
            if(sum == capacity){
                counts += 1;
                sum = 0;
            }
            if(sum > capacity){
                counts += 1;
                sum = weights[i];
            }
        }
        return counts+1;
    }

    private static int maxCapacity(int[] weights) {
        int sum = 0;
        for(int i = 0; i<weights.length; i++){
            sum += weights[i];
        }
        return sum;
    }

    private static int minCapacity(int[] weights) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<weights.length; i++){
            if(weights[i] >= max)
                max = weights[i];
        }
        return max;
    }
}
