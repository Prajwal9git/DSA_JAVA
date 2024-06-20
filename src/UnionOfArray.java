import java.util.*;
public class UnionOfArray {
    public static void main(String[] args) {
        List<Integer> result = new ArrayList();
        int a[] = {1, 2, 3, 3};
        int b[] = {2, 2, 4};
        result = sortedArray(a, b);
        System.out.println(result);
    }

    public static List< Integer > sortedArray(int []a, int []b) {
        // Write your code here
        List<Integer> arr = new ArrayList();

        int i = 0;
        int j = 0;
        while(i<a.length && j<b.length){
            if(i < a.length-1 && a[i] == a[i+1]){
                i++;
                continue;
            }
            if(j < b.length-1 &&b[j] == b[j+1]){
                j++;
                continue;
            }

            if(a[i] == b[j]){

                arr.add(a[i]);
                i++;
                j++;
            }

            else if(a[i] > b[j]){
                arr.add(b[j]);
                j++;
            }
            else{
                arr.add(a[i]);
                i++;
            }
        }
        if(i !=a.length)
            for(int k = i; k<a.length; k++)
                arr.add(a[k]);
        else if(j !=b.length)
            for(int k = j; k<b.length; k++)
                arr.add(b[k]);

        return arr;
    }
}
