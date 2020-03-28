package com.mylearnings.generics;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by ronnie on 3/30/17.
 */
public class MyGenericTest {

    @Test
    public void runTest(){

        MyGeneric<Integer> value = new MyGeneric<>();
        MyGeneric<Integer> test = new MyGeneric<>();
        assertTrue(value.getValue(3).equals(3));
        assertTrue(value.getObject(test).equals(test));

        assertTrue(MyGeneric.getObjectStatic(test).equals(test));

        LinkedList<Number> vals = new LinkedList<>();
        vals.add(1);
        vals.add(5);
        vals.add(4);
        LinkedList<Integer> valint = new LinkedList<>();
        valint.add(1);
        valint.add(3);
        MyGeneric<Number> testNum = new MyGeneric<>();
        assertTrue(testNum.getSize(vals)==3 & testNum.getSize(valint)==2);


    }

}