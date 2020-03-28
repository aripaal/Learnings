package com.mylearnings.threads;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ronnie on 3/31/17.
 */
public class Example {


    public static void main(String args[]){
        ExecutorService service = Executors.newFixedThreadPool(2);
        Signal signal= new Signal();

        try{
            service.execute(
                    ()->{

                        signal.doWait();
                        System.out.println("Signal processed");
                    }

            );

            service.execute(
                    ()->{

                        System.out.println("sending signal");
                        signal.doNotify();

                    }


            );

        }finally {
            if(service!=null)service.shutdown();
        }
        MyCyclicBarrier cyclicBarrier= new MyCyclicBarrier(2);
        ExecutorService service1 = Executors.newFixedThreadPool(2);
        try{
            service1.execute(()->
            { cyclicBarrier.doWait();
                System.out.println("Cyclic barrier broken");
            });
            service1.execute(()->
            { System.out.println("Notifying cyclic barrier task1");
                cyclicBarrier.doNotify();

            });
            service1.execute(()->
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Notifying cyclic barrier task2");
                cyclicBarrier.doNotify();

            });
        }
        finally {
            if(service1!=null)service1.shutdown();
        }

    }

    private static class Signal{
        private boolean hasSignalToProcess=false;

        public synchronized void doWait(){
            while(!hasSignalToProcess){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            hasSignalToProcess=false;
        }
        public synchronized void doNotify(){
            hasSignalToProcess=true;
            this.notify();
        }

    }
    public static class MyCyclicBarrier{

        private boolean signal;
        private int counter;
        private int counter_maxSize;

        public MyCyclicBarrier(int counter) {
            this.counter = counter;
            this.counter_maxSize=counter;
        }

        public synchronized void doWait(){
            while(!signal){

                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            signal=false;
        }

        public synchronized void doNotify(){
            --counter;
            if(counter==0){
                signal=true;
                notifyAll();
                counter=counter_maxSize;
            }
        }




    }

}
