package com.mylearnings.datastructure;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ronnie on 3/29/17.
 */
public class QueueTest {
    Queue<Integer> queue;

    @Before
    public void setUp(){

        queue = new Queue<>();
    }


    @Test
    public void enQueue() throws Exception {
        queue.enQueue(1);
        assertTrue(queue.getLast()==queue.getFirst() & queue.getSize()==1);
        queue.enQueue(2);
        queue.enQueue(5);
        assertTrue(queue.getLast()!=queue.getFirst() &
                queue.getSize()==3 &
                queue.getFirst().getValue()==1);
    }
    @Test
    public void deQueue() throws Exception {
        assertNull(queue.deQueue());

        queue.enQueue(1);
        assertTrue(queue.deQueue()==1 & queue.size==0);

        queue.enQueue(2);
        queue.enQueue(5);
        assertTrue(queue.deQueue()==2 & queue.size==1);
    }

}