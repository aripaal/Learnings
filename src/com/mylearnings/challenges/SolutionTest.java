package com.mylearnings.challenges;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ronnie on 5/1/17.
 */
public class SolutionTest {

    @Test
    public void result() throws Exception {
        ThreadMultiply multiply = new ThreadMultiply(1,2,3,4);
        assertTrue(multiply.result()==21);
    }
    @Test
    public void testLenghtOfLastWord(){
        String word="";
        assertTrue(Others.lengthOfLastWord(word)==0);
        word="Helli I am Arijit";
        assertTrue(Others.lengthOfLastWord(word)==6);

    }
    @Test
    public void testLongestSubStringNoRepeat(){
       assertTrue(Others.longestSubStringNoRepeat("abcdaadnaos").equals("abcd"));
        //System.out.println(Others.longestSubStringNoRepeat("abcdaadna"));
    }

    @Test
    public void testKthLargest(){
        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(4);
        l.add(6);
        l.add(3);


        assertTrue(Others.findKLargest(l,2)==4);



    }
}