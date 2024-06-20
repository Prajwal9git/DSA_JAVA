package com.Prajwal;
import com.Prajwal.Recursion.Subsequence;

import java.util.*;

//hi there


public class Solution {
    public static void main(String[] args) {
        int array[] = {1, 2, 2};
        PowerSetWithoutDublicate(array);
        PowerSet(array);
        Subsequence ss = new Subsequence();
        System.out.println((ss.subWithDuplicates(array)));
    }

    public static String removeAll_a(String str){
        if(str.length() == 0) return "";
        if(str.charAt(0) == 'a')
            return ""+removeAll_a(str.substring(1));
        return str.charAt(0)+removeAll_a(str.substring(1));
    }

    public static ArrayList<Integer> sumTriangle(int array[]){
        ArrayList<Integer> list = new ArrayList<>();
        if(array.length == 1){
            list.add(array[0]);
            return list;
        }
        for(int i = 0; i<array.length-1; i++){
            list.add(array[i]+array[i+1]);
        }
        int[] nextArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nextArray[i] = list.get(i);
        }

        ArrayList<Integer> result = sumTriangle(nextArray);

        for (int num : array) {
            result.add(num);
        }

        return result;
    }

    public char findUpperCase(String str){
        if(str.isEmpty()) return ' ';
        char ch = str.charAt(0);
        if(ch >= 65 && ch <= 97) return ch;
        return findUpperCase(str.substring(1));
    }
    public int binaryRecursion(int array[], int start, int end, int target){
        int mid = (start+end)/2;

        if(start > end) return -1;

        if(target == array[mid])
            return mid;
        else if(array[mid] > target){
            return binaryRecursion(array, start, mid-1, target);
        }
        else return binaryRecursion(array, mid+1, end, target);
    }

    public static void diceSum(String p, int up){
        if(up==0){
            System.out.println(p);
            return;
        }
        for(int i = 1; i<=6&&i<=up; i++){
            diceSum(p+i, up - i);
        }
    }

    public static void dialPad(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';
        for(int i = (digit - 1)*3; i<digit*3; i++){
            char ch = (char)(i+'a');
            dialPad(p+ch, up.substring(1));
        }
    }

    public static int dialPadCount(String p, String up){
        if(up.isEmpty()) return 1;

        int digit = up.charAt(0) - '0';
        int count = 0;
        for(int i = (digit-1)*3; i<digit*3; i++){
            char ch = (char)(i+'a');
            count= count + dialPadCount(p+ch, up.substring(1));
        }
        return count;
    }

    public static void PowerSetWithoutDublicate(int array[]){
        Arrays.sort(array);
        int start = 0;
        int end = 0;
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int i = start; i<array.length; i++){
            start = 0;
            if(i>0&&array[i] == array[i-1]) start = end +1;
            end = outer.size()-1;
            int n = outer.size();
            for(int j = start; j<n;j++){
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(array[i]);
                outer.add(inner);
            }
        }
        System.out.println(outer);
    }
    public static void PowerSet(int array[]){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for(int num:array){
            int n = outer.size();
            for(int i = 0; i<n ;i++){
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        System.out.println(outer);
    }
}
