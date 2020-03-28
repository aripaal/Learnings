package com.mylearnings.sorting;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by ronnie on 3/30/17.
 */
public class SortTest {
    Integer[] unsorted= {1,7,3,5,3};
    Integer [] expected={1,3,3,5,7};
    @Test
    public void insertSort() throws Exception {
        InsertSort<Integer> sortTest = new InsertSort<>();
        List<Integer> sorted= sortTest.sort(Arrays.asList(unsorted));
        assertArrayEquals(sorted.toArray(),expected);
        sorted.forEach(System.out::println);
    }

    @Test
    public void quickSort() throws Exception{
        QuickSort<Integer> sort = new QuickSort<>();
        List<Integer> sorted=sort.sort(Arrays.asList(unsorted));
        assertArrayEquals(sorted.toArray(),expected);
        sorted.forEach(System.out::println);

    }
    @Test
    public void bubbleSort() throws Exception {
        BubbleSort<Integer> sort = new BubbleSort<>();
        List<Integer> sorted=sort.sort(Arrays.asList(unsorted));
        assertArrayEquals(sorted.toArray(),expected);
        sorted.forEach(System.out::println);
    }

    @Test
    public void mergeSort() throws Exception {
        MergeSort<Integer> sort = new MergeSort<>();
        List<Integer> sorted=sort.sort(Arrays.asList(unsorted));
        assertArrayEquals(sorted.toArray(),expected);
        sorted.forEach(System.out::println);
    }
}
