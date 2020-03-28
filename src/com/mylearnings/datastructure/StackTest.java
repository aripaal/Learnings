package com.mylearnings.datastructure;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ronnie on 3/29/17.
 */
public class StackTest {

    Stack<Integer> stack;
    @Before
    public void setUp(){
        stack= new Stack<>();

    }

    @Test
    public void testAdd(){
        stack.push(1);
        assertTrue(stack.getBottom()==stack.getTop());

        stack.push(4);
        assertTrue(stack.getBottom()!=stack.getTop());

    }

    @Test
    public void testPop(){

        assertNull(stack.pop());
        stack.push(1);
        assertTrue(stack.pop()==1 & stack.getSize()==0);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertTrue(stack.pop()==3 & stack.getTop().getValue()==2 & stack.getBottom().getValue()==1);

    }

}