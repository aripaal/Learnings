package com.mylearnings.threads;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Created by ronnie on 4/30/17.
 */
public class FindMaxFJ<T extends Comparable<T>> extends RecursiveTask<T> {
    List<T> list,mergedList;
    int threshold;


    public FindMaxFJ(List<T> list, int threshold) {
        this.list = list;
        this.threshold = threshold;
    }

    @Override
    protected T compute() {
        int size=list.size();
       if(size > threshold){
           System.out.println("Current Thread:"+Thread.currentThread().getName());
           List<RecursiveTask<T>> tasks=computeRecursively(list);
           for(RecursiveTask<T> task:tasks)
               task.fork();
            mergedList=new LinkedList<T>();
           for(RecursiveTask<T> task:tasks)
               mergedList.add(task.join());
           return getMax(mergedList);

       }else{
           System.out.println("Current Thread computing:"+Thread.currentThread().getName());
           return getMax(list);
       }
    }

    public List<RecursiveTask<T>> computeRecursively(List<T> list){
        List<RecursiveTask<T>> tasks=new LinkedList<>();
        tasks.add(new FindMaxFJ<T>(list.subList(0,list.size()/2),threshold));
        tasks.add(new FindMaxFJ<T>(list.subList(list.size()/2,list.size()),threshold));
        return tasks;

    }

    private T getMax(List<T> input){
        return Collections.max(input);
    }

    public static void main(String... args){
        List<Integer> list = Arrays.asList(1,3,3,4,2,4,5,2,3,4,102,33,1,3,3,4,2,4,5,2,3,4,102,33,1,3,3,4,2,4,5,2,3,4,102,33);
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(" Max: "+pool.invoke(new FindMaxFJ<Integer>(list,3)));

    }
}
