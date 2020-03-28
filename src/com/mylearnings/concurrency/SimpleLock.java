package com.mylearnings.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ronnie on 4/12/17.
 */
public class SimpleLock {

    public static class MyLock{

        boolean isLocked = false;
        public synchronized void lock() throws Exception
        {

            while(isLocked)
                wait();

            isLocked=true;
        }

        public synchronized void unLock() throws Exception
        {
            isLocked=false;
            notifyAll();
        }

    }
    public static class TestLock{
        MyLock lock;

        public TestLock(MyLock lock) {
            this.lock = lock;
        }

        public void myMethod() throws Exception{
            lock.lock();
            Thread.sleep(3000);
            System.out.println(" Hello from "+Thread.currentThread().getName());
            myMethod2();

        }

        private void myMethod2() throws Exception{
            System.out.println("Inside another method");
            lock.unLock();
        }

    }

    public static void main(String args[]){
        ExecutorService executorService= Executors.newCachedThreadPool();
        MyLock lock = new MyLock();
        TestLock testLock=new TestLock(lock);
        try{
            executorService.submit(()->{
                try {
                    testLock.myMethod();
                }catch(Exception e){e.printStackTrace();}
            });

            executorService.submit(()->{
                try {
                    testLock.myMethod();
                }catch(Exception e){e.printStackTrace();}
            });
            executorService.submit(()->{
                try {
                    testLock.myMethod();
                }catch(Exception e){e.printStackTrace();}
            });
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if(executorService!=null)executorService.shutdown();
        }
    }

}
