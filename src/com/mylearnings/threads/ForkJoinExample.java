package com.mylearnings.threads;

import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Created by ronnie on 4/4/17.
 */
public class ForkJoinExample extends RecursiveAction{
    private int threshold=10;
    private Integer max;
    private List<Integer> array;


    public ForkJoinExample(List<Integer> array) {
        this.array = array;
    }

    public Integer getMax() {
        return max;
    }

    @Override
    protected void compute() {
        System.out.println("To compute arraySize:"+array.size());
        if(array.size()<threshold){
            computeDirectly(array);

        }
        else{
            ForkJoinExample left = new ForkJoinExample(array.subList(0,array.size()/2));
            ForkJoinExample right = new ForkJoinExample(array.subList(array.size()/2,array.size()));
            invokeAll(left,right);

            if(left.getMax()>right.getMax()){
                max=left.getMax();
            }
            else
                max=right.getMax();
        }
    }


    private void computeDirectly(List<Integer> array){
        System.out.println("Thread: "+Thread.currentThread().getName()+" array size: "+array.size());
        max=array.get(0);

        for(int i=1;i<array.size();i++)
            if(array.get(i)>max)
                max=array.get(i);
    }
}
