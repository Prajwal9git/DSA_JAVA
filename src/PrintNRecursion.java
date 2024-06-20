import java.util.*;
public class PrintNRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int x = sc.nextInt();
        System.out.println(Arrays.toString(printNos(x)));
    }

    public static int[] printNos(int x) {
        // Write Your Code Here
        int count = x;
        int arr[] = new int[x];
        return ret_rec(count, x, arr);
    }
    public static int[] ret_rec(int count, int x, int[] arr){
        if(x==1){
            arr[count-1] = x;
            return arr;
        }

        arr[count-1] = x;
        count--;
        x--;
        ret_rec(count, x, arr);
        return arr;
    }
}
