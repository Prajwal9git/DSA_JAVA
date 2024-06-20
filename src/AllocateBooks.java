import java.util.*;
public class AllocateBooks {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12, 34, 67, 90));
        int n = 4;
        int m = 2;
        int ans = findPages(arr, n, m);
        System.out.println("The answer is: " + ans);
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {

        if(m > n) return -1;


        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();


        while(low<=high){
            int mid = low + (high - low)/2;
            int count = possibleBook(arr, mid);
            count = possibleBook(arr, mid);
            if(count > m) low = mid+1;
            else high = mid - 1;
        }
        return low;
    }

    private static int possibleBook(ArrayList<Integer> arr, int pages){
        long sum = 0;
        int count = 1;
        //int max = 0;
        for(int i = 0; i<arr.size(); i++){
            if((sum + arr.get(i)) <= pages) sum+=arr.get(i);
            else{
                //max = sum;
                sum = arr.get(i);
                count++;
            }
        }

        return count;
    }


}
