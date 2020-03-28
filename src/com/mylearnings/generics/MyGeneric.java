package com.mylearnings.generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ronnie on 3/30/17.
 */
public class MyGeneric<T> {

    public T getValue(T val){
        return val;
    }

    public  MyGeneric<T> getObject(MyGeneric<T> value){
        MyGeneric<T> newValue = new MyGeneric<T>();
        newValue=value;
        return newValue;

    }
    public static<T> MyGeneric<T> getObjectStatic(MyGeneric<T> value){
        return value;
    }

    public int getSize(List<? extends T> value){

        return value.size();
    }

    public static MyGeneric doSomething(){
        return new MyGeneric();
    }


    public void sumOfList(List<?> list){

        for(Object n:list)
            System.out.println(n);


    }

    public static void main(String... args){
        MyGeneric g = new MyGeneric();
        Integer[] l ={1,3,5};
        String[] s = {"one","two"};
        g.sumOfList(Arrays.asList(l));
        g.sumOfList(Arrays.asList(s));

    }

}
