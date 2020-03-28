package com.mylearnings.concurrency;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.*;
import java.util.List;
/**
 * Created by ronnie on 3/29/17.
 */
public class Example1 {

    public void sayHello(){

        System.out.println("Hello");
    }

    public void sayBye(){
        System.out.println("Bye");
    }
    public Integer returnRandomInt(){
        return new Random().nextInt(100);

    }

    public void saySomething(){
        System.out.println("something");
    }
    public Example1() {
    }

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorService service= Executors.newCachedThreadPool();
       ScheduledExecutorService scheduledService= Executors.newScheduledThreadPool(1);
       try{
            Example1 ex1= new Example1();
           scheduledService.schedule(()->ex1.saySomething(),2,TimeUnit.SECONDS);
//            for(int i=0;i<15;i++) {
//                service.execute(()->ex1.sayHello());
//                service.execute(()->ex1.sayBye());
//                Future<Integer> future=service.submit(()->ex1.returnRandomInt());
//                System.out.println(future.get());
//            }
            List<Callable<Integer>> callables = new LinkedList<>();
            callables.add(()->ex1.returnRandomInt());
            callables.add(()->ex1.returnRandomInt());

            List<Future<Integer>> results=service.invokeAll(callables);

            for(Future<Integer> future: results){
                System.out.println(future.get());
            }
        }finally {
            if(service!=null)service.shutdown();
//            if(scheduledService!=null)scheduledService.shutdown();
        }

    }

}
