package com.mylearnings.mathproblems;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ronnie on 3/30/17.
 */
public class genericProblemTest {
    @Test
    public void isUnique() throws Exception {
        String word1 = "abcdef";
        String word2= "abcada";
        genericProblem problem= new genericProblem();
        assertTrue(problem.isUnique(word1));
        assertFalse(problem.isUnique(word2));

    }

}