package com.mylearnings.generics;

import java.util.List;

/**
 * Created by ronnie on 3/25/17.
 */
public class Storage<T>{

    public boolean isBelow(List<? extends Comparable<T>> list, T value){
        return list.stream().allMatch(a-> a.compareTo(value)==0);
    }


}
