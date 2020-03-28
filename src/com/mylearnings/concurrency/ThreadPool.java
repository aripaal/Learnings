package com.mylearnings.concurrency;

import jdk.nashorn.internal.ir.Block;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Logger;


/**
 * Created by ronnie on 4/21/17.
 */
public class ThreadPool {
    BlockingQueue<Runnable> taskQueue=null;
    List<WorkerThreads> workers=null;
    int MAX_TASKS,MAX_WORKERS;

    public ThreadPool(int MAX_TASKS, int MAX_WORKERS) {
        this.MAX_TASKS = MAX_TASKS;
        this.MAX_WORKERS = MAX_WORKERS;
        taskQueue=new ArrayBlockingQueue<Runnable>(MAX_TASKS);
        workers=new ArrayList<>(MAX_WORKERS);

        for(int i=0;i<MAX_WORKERS;i++)
            workers.add(new WorkerThreads());

        for(WorkerThreads worker: workers){
            worker.start();
        }

    }

    public synchronized void execute(Runnable r){
        taskQueue.add(r);
    }
    public synchronized void shutdown(){
        for(WorkerThreads worker: workers){
            worker.doStop();
        }
    }

    class WorkerThreads extends Thread{
        private boolean isStopped=false;
        @Override
        public void run(){
            while(!isStopped){
                try {
                    Runnable r = taskQueue.take();
                    r.run();
                } catch (InterruptedException e) {
                    // e.printStackTrace();
                }
            }
        }

        public synchronized void doStop(){
            isStopped=true;
            this.interrupt();
            //Thread t = new Thread();
        }

    }

    public static void main(String... args){
        ThreadPool pool=null;
        try{
            pool = new ThreadPool(4,2);
            pool.execute(()->{
                System.out.println("Hello from "+Thread.currentThread().getName());
            });

            pool.execute(()->{
                System.out.println("Hello from "+Thread.currentThread().getName());
            });
            pool.execute(()->{
                System.out.println("Hello from "+Thread.currentThread().getName());
            });
            Thread.sleep(3000);
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            if(pool!=null)pool.shutdown();
        }

    }


}
