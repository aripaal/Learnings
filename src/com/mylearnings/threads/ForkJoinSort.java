package com.mylearnings.threads;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Created by ronnie on 4/4/17.
 */
public class ForkJoinSort extends RecursiveAction {
    List<Integer> unordered;
    private int THRESHOLD=5;


    @Override
    public void compute(){
        if(unordered.size()<THRESHOLD){}


    }


    private void sort(List<Integer> array){

//        while(s)


    }
}
