package com.mylearnings.datastructure;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by ronnie on 3/27/17.
 */
public class LinkedListTest {
    LinkedList<String> list;

    @Before
    public void setUp(){

        list = new LinkedList<>();
        list.addNode("Arijit");
        list.addNode("Rekha");
        list.addNode("Anand");

    }

    @Test
    public void testSize(){

        assertTrue(list.getSize()==3);
    }

    @Test
    public void testFirst(){

        assertTrue(list.getFirst().getValue().equalsIgnoreCase("Arijit"));
    }

    @Test
    public void testLast(){
        assertTrue(list.getLast().getValue().equalsIgnoreCase("Anand"));


    }

//    @Test
//    public void testRecurse(){
//        LinkedList<String> newList= list.recurse();
//        assertTrue(newList.getSize()==3);
//        assertTrue(newList.getFirst().getValue().equalsIgnoreCase("Anand"));
//        assertTrue(newList.getLast().getValue().equalsIgnoreCase("Arijit"));
//        newList.forEach(System.out::println);
//    }

    @Test
    public void testRemoveDuplicates(){
        LinkedList<Integer> list1=new LinkedList<>();
        list1.addNode(1);
        list1.addNode(1);
        list1.addNode(3);
        list1.addNode(4);
        list1.addNode(5);
        list1.addNode(6);
        list1.addNode(7);
        System.out.println("len:"+ list1.getSize());
        list1.removeDuplicates();

       list1.forEach(System.out::println);

    }

}