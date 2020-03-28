package com.mylearnings.challenges;

import java.util.concurrent.*;

/**
 * Created by ronnie on 5/1/17.
 */
public class ThreadMultiply {
    int a,b,c,d;

    public ThreadMultiply(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    private static class MyCallable implements Callable<Integer>{
        Integer x,y;

        public MyCallable(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        public Integer call(){

            return x+y;
        }

    }

    public Integer result(){
        ExecutorService ex = Executors.newCachedThreadPool();
        Integer value = null;
        try{
            Future<Integer> result1= ex.submit(new MyCallable(a,b));
            Future<Integer> result2= ex.submit(new MyCallable(c,d));
            value = result1.get() * result2.get();
        }catch (InterruptedException|ExecutionException e) {
            e.printStackTrace();
        } finally {
            if(ex!=null)ex.shutdown();
        }

        return value;
    }

}
