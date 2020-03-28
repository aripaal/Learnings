package com.mylearnings.sorting;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ronnie on 3/30/17.
 */
public class InsertSort<T extends Comparable<T>> {

    public List<T> sort(List<T> unsorted){
        List<T> sorted = new LinkedList<>();
        loop:for(int i=0;i<unsorted.size();i++){
            for(int j=0;j<sorted.size();j++){
                if(unsorted.get(i).compareTo(sorted.get(j))<0){
                    sorted.add(j,unsorted.get(i));
                    continue loop;
                }
            }

            sorted.add(sorted.size(),unsorted.get(i));
        }
        return sorted;
    }
}
