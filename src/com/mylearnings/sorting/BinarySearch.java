package com.mylearnings.sorting;

import java.util.List;

/**
 * Created by ronnie on 3/31/17.
 */
public class BinarySearch<T extends Comparable<T>> {

    public int findIndexOf(List<T> sorted,T value) {
        int halfSize=sorted.size()/2;
       if(value.compareTo(sorted.get(halfSize))<0)
           return findIndexOf(sorted.subList(0,halfSize),value);
       else if(value.compareTo(sorted.get(halfSize))>0)
           return halfSize+findIndexOf(sorted.subList(halfSize,sorted.size()),value);
       else
           return halfSize;

    }
}
