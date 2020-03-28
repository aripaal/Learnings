package com.mylearnings.cci;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ronnie on 4/8/17.
 */
public class ArraysAndStringsTest {
    ArraysAndStrings as;
    @Before
    public void setup(){
        as=new ArraysAndStrings();
    }

    @Test
    public void testunique() {
        assertFalse(as.checkUniqueCharacters("Hello"));
        assertTrue(as.checkUniqueCharacters("HABCea"));

    }

    @Test
    public void stringCompressionTest(){
        System.out.println(as.stringCompression("aaabbbbbcdaa"));

    }
    @Test
    public void testPermute(){
        assertTrue(as.checkPermutation("ABC","BAC"));

        assertTrue(as.checkPermutation("AZ","ZA"));

    }
}