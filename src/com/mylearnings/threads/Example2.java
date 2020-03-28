package com.mylearnings.threads;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ronnie on 3/31/17.
 */
public class Example2 {
    public static class MyBlockingQueue<T>{
        private List<T> blockingQueue;
        private int MAX_SIZE;

        public MyBlockingQueue(int MAX_SIZE) {
            this.MAX_SIZE = MAX_SIZE;
            blockingQueue=new LinkedList<T>();
        }

        public synchronized void enqueue(T value){
            //Block if size reaches Max Size
            while(blockingQueue.size()==MAX_SIZE){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(blockingQueue.size()==0)
                this.notifyAll();
            System.out.println("Adding->"+value);
            blockingQueue.add(value);

        }

        public synchronized T dequeue(){
            //Block if size is empty
            while(blockingQueue.size()==0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(blockingQueue.size()==MAX_SIZE)
                this.notifyAll();
            T value=blockingQueue.remove(0);
            System.out.println("removing->"+value);
            return value;
        }
    }
    public Integer getRandom(){
        return new Random().nextInt(100);

    }

    public static void main(String args[]){

        ExecutorService executorService = Executors.newCachedThreadPool();
        Example2 example2 = new Example2();
        MyBlockingQueue<Integer> blockingQueue = new MyBlockingQueue<>(10);

        try{
            executorService.execute(
                    ()->{
                        for(int i=0;i<30;i++)
                            blockingQueue.enqueue(example2.getRandom());
                    }
            );
            executorService.execute(
                    ()->{
                        for(int i=0;i<33;i++)
                            blockingQueue.dequeue();
                    }
            );

        }finally {
            if(executorService!=null)executorService.shutdown();
        }

    }

}
