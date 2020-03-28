package com.mylearnings.generics;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ronnie on 3/30/17.
 */
public class Generic2Test {

    @Test
    public void doTest(){
        Generic2 gen=new Generic2();
        LinkedList<Number> vals = new LinkedList<>();
        vals.add(1);
        vals.add(5);
        vals.add(4);

        int some=gen.returnSomething(vals);
        System.out.println(some);

    }

}