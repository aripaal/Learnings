package com.mylearnings.concurrency;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ronnie on 4/21/17.
 */
public class BlockingQueue <T>{
    Queue<T> bQueue=new LinkedList<>();
    int MAX_SIZE=5;

    public synchronized void enQueue(T value) throws InterruptedException
    {
        while(bQueue.size()==MAX_SIZE)
            wait();
        if(bQueue.size()==0)
            notifyAll();

        bQueue.add(value);

    }

    public synchronized T deQueue() throws InterruptedException{
        while(bQueue.size()==0)
            wait();
        if (bQueue.size()==MAX_SIZE)
            notifyAll();
        return bQueue.poll();
    }

    }

