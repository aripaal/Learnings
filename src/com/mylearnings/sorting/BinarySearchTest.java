package com.mylearnings.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by ronnie on 3/31/17.
 */
public class BinarySearchTest {
    Integer [] sorted={1,2,3,5,7,10,14,34,40};
    @Test
    public void findIndexOf() throws Exception {
        BinarySearch<Integer> search = new BinarySearch<>();
        assertTrue(search.findIndexOf(Arrays.asList(sorted),5)==3);
        assertTrue(search.findIndexOf(Arrays.asList(sorted),1)==0);
        assertTrue(search.findIndexOf(Arrays.asList(sorted),3)==2);
        assertTrue(search.findIndexOf(Arrays.asList(sorted),34)==7);
        //System.out.println(search.findIndexOf(Arrays.asList(sorted),5));

    }

}