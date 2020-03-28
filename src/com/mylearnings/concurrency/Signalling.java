package com.mylearnings.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ronnie on 4/21/17.
 */
public class Signalling {

    boolean signal=false;

    public synchronized void take() throws InterruptedException{
        while(signal){
            this.wait();
        }

        signal=true;

    }


    public synchronized  void put() throws InterruptedException{
        signal=false;
        this.notifyAll();
    }


    public static void main(String... args){

        ExecutorService executorService = Executors.newCachedThreadPool();
        Signalling signalling=new Signalling();
        executorService.submit(
                ()->{


                    try {
                        signalling.take();
                        System.out.println("hello inside signal"+Thread.currentThread().getName());
                        Thread.sleep(3000);
                        signalling.put();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

        );
        executorService.submit(
                ()->{


                    try {
                        signalling.take();
                        System.out.println("hello inside signal"+Thread.currentThread().getName());
                        Thread.sleep(3000);
                        signalling.put();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

        );



    }


}
