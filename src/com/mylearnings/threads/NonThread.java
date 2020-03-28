package com.mylearnings.threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ronnie on 3/14/17.
 */
public class NonThread {
    public static void main(String args[]) throws InterruptedException{

        Thread t1 = new Thread(()->{
            for(int i=0;i<5;i++){
                System.out.println("Hello");
            }

        });

        t1.start();
        ExecutorService service=null;
        try{
            service = Executors.newFixedThreadPool(2);
            service.execute(()->{
                for(int i=0;i<135;i++)
                System.out.println("Hello there");

            });

            service.execute(()->{
                for(int i=0;i<115;i++)
                    System.out.println("Hello mama!!");


            });

        }finally{
            if(service!=null){
                service.shutdown();
            }
        }
        System.out.println("There you go");
        Thread.sleep(500);
        System.out.println("There you go again");
    }


}
