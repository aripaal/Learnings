package com.mylearnings.sorting;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ronnie on 3/31/17.
 */
public class MergeSort<T extends Comparable<T>> {

    public List<T> sort(List<T> unsorted){
        if(unsorted.size()<2)
            return unsorted;

        List<T> left = unsorted.subList(0,unsorted.size()/2);
        List<T> right = unsorted.subList(unsorted.size()/2,unsorted.size());

        return merge(sort(left),sort(right));
    }

    private List<T> merge(List<T> left, List<T> right){

        int leftPtr=0,rightPtr=0;
        List<T> merged = new LinkedList<>();
        while(leftPtr<left.size() && rightPtr<right.size()){
            if(left.get(leftPtr).compareTo(right.get(rightPtr))<0){
                merged.add(left.get(leftPtr++));
            }
            else {
                merged.add(right.get(rightPtr++));
            }
        }

        while(leftPtr<left.size())
            merged.add(left.get(leftPtr++));

        while(rightPtr<right.size())
            merged.add(right.get(rightPtr++));

        return merged;


    }

}


