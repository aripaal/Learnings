package com.mylearnings.threads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ronnie on 3/14/17.
 */
public class MyThread implements Runnable{

    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Hello");
        }
    }
    public static void main(String args[]){

        Thread t1 = new Thread(new MyThread());
        t1.start();
        AtomicBoolean b = new AtomicBoolean();
        AtomicInteger integer = new AtomicInteger();

    }



}
