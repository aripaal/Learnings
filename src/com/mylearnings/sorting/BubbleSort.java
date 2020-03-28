package com.mylearnings.sorting;

import java.util.List;

/**
 * Created by ronnie on 3/30/17.
 */
class BubbleSort<T extends Comparable<T>>{
    public List<T> sort(List<T> list){

        boolean isSorted=false;
        while(!isSorted){
            isSorted=true;
            for(int i=0;i<list.size()-1;i++){
                if(list.get(i).compareTo(list.get(i+1))>0){
                    T temp = list.get(i);
                    list.set(i,list.get(i+1));
                    list.set(i+1,temp);
                    isSorted=false;
                }
            }
        }
        return list;
    }
}