import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 4, 1};

        int i = 0;
        while(i < arr.length){
            if(arr[i] == i + 1) i++;
            else{
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
