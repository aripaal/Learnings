package com.mylearnings.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ronnie on 4/12/17.
 */
public class SimpleReentrantLock {

    public static class MyReentrantLock {

        boolean isLocked =false;
        Thread currentThread=null;
        int count=0;
        public synchronized void lock() throws Exception{

            while(isLocked==true && Thread.currentThread()!=currentThread )
                wait();

            currentThread=Thread.currentThread();
            isLocked=true;
            ++count;
        }

        public synchronized void unLock() throws Exception{

            if(Thread.currentThread()==currentThread){
                --count;
                if(count==0){
                    isLocked=false;
                    notifyAll();
                }
            }
        }

    }
    public static class TestLock{
        MyReentrantLock lock;

        public TestLock(MyReentrantLock lock) {
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
            lock.lock();
            System.out.println("Inside second lock");

            lock.unLock();
            System.out.println("unlocking second lock");
            lock.unLock();
        }

    }

    public static void main(String args[]){
        ExecutorService executorService= Executors.newCachedThreadPool();
        MyReentrantLock lock = new MyReentrantLock();
        TestLock testLock=new TestLock(lock);
        try{
            new Thread(
                    ()->{
                        System.out.println("hello");
                    }
            ).start();
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
