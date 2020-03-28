package com.mylearnings.threads;

import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ronnie on 3/14/17.
 */
public class MyThread2 {
    public static void main(String args[]) throws InterruptedException,ExecutionException,TimeoutException{

        ExecutorService service = null;
        try{
            service = Executors.newSingleThreadExecutor();
            service.execute(()-> System.out.println("ello"));
            List<Integer> integerList = new LinkedList<>();
            integerList.add(1);
            integerList.add(4);
            integerList.add(6);

            Future<Integer> future = service.submit(()-> 5);
            Integer x=future.get(5, TimeUnit.MILLISECONDS);
            System.out.println(x);

            Future<List<Integer>> futureList= service.submit(
                    ()->{
                          Stream<Integer> s=integerList.stream();
                          Map<Boolean,List<Integer>> map=s.map(i->i+2).collect(Collectors.partitioningBy(i-> i>3));
                          return map.get(true);
                    }
            );
            System.out.println(futureList.get());

        }finally{
            if(service!=null)   service.shutdown();

        }



    }
}
