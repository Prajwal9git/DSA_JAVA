package com.Prajwal.Recursion;

import javax.sound.sampled.Line;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Recursion {
    public boolean checkSorted(int []arr, int i){
        if(i == arr.length - 1) return true;
        return (arr[i] < arr[i + 1]) && checkSorted(arr, i+1);
    }
    public int fibForm(int n){
        int fib = (int) ((Math.pow(((1 + Math.sqrt(5))/2), n) - Math.pow(((1 - Math.sqrt(5))/2), n)) / Math.sqrt(5));
        return fib;
    }

    public int LinearSearch(int array[], int index, int target){
        if(index == array.length) return -1;

        if(array[index] == target) return index;
        return LinearSearch(array, index+1, target);
    }

    public ArrayList<Integer> LinearSearchAllIndex(int array[], int index, int target){
        ArrayList<Integer> list = new ArrayList<>();
        if(index == array.length) return list;

        if(array[index] == target) list.add(index);
        ArrayList<Integer> returbfromBelowRecursion = LinearSearchAllIndex(array, index+1, target);

        list.addAll(returbfromBelowRecursion);
        return list;
    }

    public static int RotatedBinarySearch(int array[], int start, int end, int target){
        if(start > end) return -1;
        int mid = start + (end - start)/2;

        if(array[mid] == target) {
            return mid;
        }


        if(array[start] <= array[mid]) {
            if (target >= array[start] && target <= array[mid])
                return RotatedBinarySearch(array, start, mid - 1, target);
            else return RotatedBinarySearch(array, mid + 1, end, target);
        }

        if(target >= array[mid] && target <= array[end]) return RotatedBinarySearch(array, mid+1, end, target);

        return RotatedBinarySearch(array, start, mid-1, target);
    }

    public int[] bubbleSort(int array[], int end, int pointer){
        if(end == 0) return array;
        if(pointer == end){
            return bubbleSort(array, end - 1, 0);
        }

        if(array[pointer] > array[pointer + 1]){
            int temp = array[pointer];
            array[pointer] = array[pointer+1];
            array[pointer + 1] = temp;
        }
        return bubbleSort(array, end, pointer + 1);
    }

    public int[] mergeSort(int array[]){
        if(array.length == 1) return array;
        int mid = array.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(array, mid, array.length));

        return merge(left, right);
    }

    private int[] merge(int[] first, int[] second){
        int i = 0;
        int j = 0;
        int k = 0;

        int[] mix = new int[first.length+second.length];
        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                mix[k] = first[i];
                i++;
                k++;
            }
            else{
                mix[k] = second[j];
                k++;
                j++;
            }
        }
        while(i<first.length){
            mix[k] = first[i];
            k++;
            i++;
        }
        while(j<second.length){
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }
}

