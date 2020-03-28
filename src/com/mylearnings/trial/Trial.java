package com.mylearnings.trial;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Trial {

    static String findC(int[] arr,int k){


        List<Integer> list = new LinkedList<>();
        for(int x: arr)
            list.add(x);

        if(list.contains(k))
            return "YES";
        return "NO";




    }

    static int[] oddNumbers(int l, int r) {
        List<Integer> list = new LinkedList<>();
        List<Integer> odds = new LinkedList<>();
        for(int val: list)
            if(val%2!=0)
                odds.add(val);
        int[] oddArr = new int[odds.size()];
        for(int i=0;i<odds.size();i++)
            oddArr[i]=odds.get(i);
        return oddArr;

    }
    static void fillNumber(List<Integer> list,int l, int r){
        for(int i=l;i<=r;i++)
            list.add(i);
    }

    public static void main(String... args){


    }
}
