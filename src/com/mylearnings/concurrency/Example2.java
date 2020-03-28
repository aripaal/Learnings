package com.mylearnings.concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by ronnie on 3/30/17.
 */
public class Example2 {

    int variable = 0;

    public int getVariable() {
        return variable;
    }
    public int increment(CyclicBarrier cyclicBarrier) throws BrokenBarrierException, InterruptedException {
        cyclicBarrier.await();
        return ++variable;
    }
    public int decrement(){
        return --variable;
    }
    public static void main(String args[]) throws InterruptedException, ExecutionException, BrokenBarrierException, TimeoutException {
        ExecutorService service = Executors.newFixedThreadPool(30);
        CyclicBarrier c1=new CyclicBarrier(2);
        try{
            Example2 ex = new Example2();
            List<Future<Integer>> results;
            List<Callable<Integer>> tasks = new LinkedList<>();

            tasks.add(()->ex.increment(c1));
            tasks.add(()->ex.increment(c1));
            tasks.add(()->ex.increment(c1));
            tasks.add(()->ex.increment(c1));
            tasks.add(()->ex.increment(c1));

            tasks.add(()->ex.increment(c1));
            tasks.add(()->ex.decrement());
            tasks.add(()->ex.decrement());
            tasks.add(()->ex.decrement());
            tasks.add(()->ex.decrement());
            tasks.add(()->ex.decrement());

            results=service.invokeAll(tasks);
            for(Future<Integer> x: results){
                System.out.println(x.get());
            }

            System.out.println(" finall:"+ex.getVariable());
        }finally{
            if(service!=null)service.shutdown();

        }



    }

}
