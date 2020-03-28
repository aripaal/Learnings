package com.mylearnings.threads;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

import static org.junit.Assert.*;

/**
 * Created by ronnie on 4/4/17.
 */
public class ForkJoinExampleTest {
    Integer[] arrayMoreThan10 = {1,4,2,45,2,5,2,5,2,56,2,3,5,6,210,4,6,3,34,200,3};
    Integer[] arrayLessThan10 = {1,4,2,45,2,5};


    @Test
    public void getMax() throws Exception {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        try {
            ForkJoinExample findMaxLessThan10 = new ForkJoinExample(Arrays.asList(arrayLessThan10));
            forkJoinPool.invoke(findMaxLessThan10);
            assertTrue(findMaxLessThan10.getMax() == 45);

            ForkJoinExample findMaxGreaterThan10 = new ForkJoinExample(Arrays.asList(arrayMoreThan10));
            forkJoinPool.invoke(findMaxGreaterThan10);
            assertTrue(findMaxGreaterThan10.getMax() == 210);
        }finally {
            if(forkJoinPool!=null){forkJoinPool.shutdown();}
        }
    }

}