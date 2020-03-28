package com.mylearnings.sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ronnie on 3/30/17.
 */
public class QuickSort<T extends Comparable<T>> {

    public List<T> sort(List<T> unsorted){
        if(unsorted.size()<2)
            return unsorted;

        T pivot = unsorted.get(0);
        List<T> lessThanPivot = new LinkedList<>();
        List<T> greaterThanPivot = new LinkedList<>();

        for(int i=1;i<unsorted.size();i++){
            if(unsorted.get(i).compareTo(pivot)<0)
                lessThanPivot.add(unsorted.get(i));
            else
                greaterThanPivot.add(unsorted.get(i));
        }

        List<T> sorted = new LinkedList<>();
        sorted.addAll(sort(lessThanPivot));
        sorted.add(pivot);
        sorted.addAll(sort(greaterThanPivot));
        return sorted;


    }
}
