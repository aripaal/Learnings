package com.mylearnings.oops;

import java.util.AbstractList;
import java.util.Arrays;

/**
 * Created by ronnie on 4/14/17.
 */
public class InheritTest {
    int x=10;
    static int y=4;
    void doThat(){
        System.out.println("in Inherittest");
    }
    static void doThis(){

        System.out.println("Doing something in InheritTest");
    }
}

class Inherited extends InheritTest{
    int x =3;
    static int y=5;
    void doThat(){
        System.out.println("in Inherited");
    }
    static void doThis(){

        System.out.println("Doing something in Inherited");
    }

    public static void main(String args[]){

        InheritTest ab = new Inherited();
        ab.doThat();
        ab.doThis();
        System.out.println("ab.x "+ab.x);

        System.out.println("ab.y "+ab.y);
        //Inherited a = new Inherited();
//        String ac=new String("hello");
//        char [] acArr=ac.toCharArray();
//        Arrays.sort(acArr);
//        String dict=String.copyValueOf(acArr);
//        System.out.println(dict);
        //Inherited.doThis();
        //InheritTest.doThis();

    }
}