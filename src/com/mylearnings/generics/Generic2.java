package com.mylearnings.generics;

import java.util.List;

/**
 * Created by ronnie on 3/30/17.
 */
public class Generic2 {

    public<T> T returnValue(T value){
        return value;
    }
    public static<T> T returnValueStatic(T value){
        return value;
    }

    public int returnSomething(List<? extends Number> value){

        return value.size();
    }


}
