package com.mylearnings.datastructure;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.*;

/**
 * Created by ronnie on 3/19/17.
 */
public class BinaryTreeTest {
    BinaryTree<Integer> tree;
    Integer[] arr,arr2,balanced,expInOrder,expPreOrder,expLevelOrder;

    @Before
    public void setUp(){
        tree = new BinaryTree<>();
        arr= new Integer[]{1,4,5,2,1};
        arr2=new Integer[]{13,9,20,15,7};
        balanced = new Integer[]{4,1,5};
        expInOrder=new Integer[]{1,1,2,4,5};
        expPreOrder=new Integer[]{1,4,2,1,5};
        expLevelOrder=new Integer[]{1,4,2,5,1};
    }

    @Test
    public void addNode() throws Exception {
        for(Integer v:arr){
            tree.add(v);
        }

    }
    @Test
    public void testInorder(){
        for(Integer v:arr){

            tree.add(v);
        }

        List<Integer> toview= new LinkedList<>();
        tree.inOrder(toview);
        assertArrayEquals(toview.toArray(),expInOrder);
        System.out.println(toview);
        toview.clear();
        tree.inOrderIt(toview);
        assertArrayEquals(toview.toArray(),expInOrder);
        System.out.println(toview);
       // tree.findValue(1);

    }

    @Test
    public void testLevelOrder(){
        for(Integer v:arr){

            tree.add(v);
        }

        List<Integer> toview= new LinkedList<>();
        tree.levelOrder(toview);
        assertArrayEquals(toview.toArray(),expLevelOrder);
        toview.forEach(System.out::println);
        System.out.println("---");
        toview.clear();
        tree.levelOrderRec(toview);
        toview.forEach(System.out::println);
        assertArrayEquals(toview.toArray(),expLevelOrder);
        //toview.forEach(System.out::println);

    }
    @Test
    public void testSize(){
//        for(Integer v:arr2){
//
//            tree.add(v);
//        }
        BinaryTree tree = new BinaryTree();

        tree.root = new BinaryTree.Node(1);
        tree.root.left = new BinaryTree.Node(2);
        tree.root.right = new BinaryTree.Node(3);
        tree.root.left.left = new BinaryTree.Node(4);
        tree.root.left.right = new BinaryTree.Node(5);

        System.out.println(tree.calcSize(tree.root));

        System.out.println(tree.funct(tree.root,1));
    }
    @Test
    public void testLevelOrderMap(){
        for(Integer v:arr2){

            tree.add(v);
        }

        tree.levelOrderMap();


    }

    @Test
    public void testPreorder(){
        for(Integer v:arr){

            tree.add(v);
        }

        List<Integer> toview= new LinkedList<>();
        tree.preOrder(toview);
        System.out.println(toview);

        toview.clear();
        tree.preOrderIt(toview);
        System.out.println(toview);
       // assertArrayEquals(toview.toArray(),expPreOrder);

    }
    @Test
    public void testSmallest(){
        for(Integer v:arr2){

            tree.add(v);
        }

        System.out.println("smallest: "+tree.findSmallestElement());

    }

    @Test
    public void checkBalanced(){
        for(Integer v:balanced){

            tree.add(v);
        }
        assertTrue(tree.isBalanced(tree.root));

    }
}