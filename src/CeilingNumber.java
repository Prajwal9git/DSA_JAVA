import java.util.*;

public class CeilingNumber {
    public static void main(String[] args) {
        int num[] = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array elements: ");

        for(int i = 0; i<num.length; i++)
            num[i] = sc.nextInt();

        System.out.println("Enter the target: ");
        int target = sc.nextInt();
        int start = 0;
        int end = num.length-1;
        System.out.println("index : "+ceiling(num, target));

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
}
