package com.mylearnings.mathproblems;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ronnie on 3/29/17.
 */
public class MathProblemTest {
    @Test
    public void reverseInteger() throws Exception {
        int expected=321;
        int input=123;

        assertEquals(MathProblem.reverseInteger(input),expected);
        input=-123;
        expected=-321;
        assertEquals(MathProblem.reverseInteger(input),expected);

    }

}