package com.Prajwal.Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    public void subSeq(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subSeq(p + ch, up.substring(1));
        subSeq(p,up.substring(1));
    }

    public ArrayList<String> subSeq2(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subSeq2(p + ch, up.substring(1));
        ArrayList<String> right = subSeq2(p,up.substring(1));
        left.addAll(right);
        return left;
    }

    public void subSeqAscii(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subSeqAscii(p + ch, up.substring(1));
        subSeqAscii(p,up.substring(1));
        subSeqAscii(p+(ch+0),up.substring(1));

    }

    public ArrayList<ArrayList<Integer>> subSeqIteration(int array[]){
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for(int num:array){
            int n = outer.size();
            for(int i = 0; i<n; i++){
                ArrayList<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }

    public List<List<Integer>> subWithDuplicates(int array[]){
        int start;
        int end = 0;
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int i = 0; i<array.length; i++){
            start = 0;
            if(i>0 && (array[i] == array[i - 1])){
                start = end + 1; // if current element in the array is same as previous element
            }
            end = outer.size() - 1;
            int n = outer.size();
            for(int j = start; j<n; j++){
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(array[i]);
                outer.add(inner);
            }
        }
        return outer;
    }
}
