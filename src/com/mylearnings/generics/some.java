package com.mylearnings.generics;

/**
 * Created by ronnie on 4/11/17.
 */
public class some {
    interface A{

        default void log(){
            System.out.println(" logging A");
        }
    }
    interface B {
        default void log(){
            System.out.println(" logging B");
        }
    }
    interface C extends A,B{
        default void log(){
            System.out.println(" logging C");
        }
        static void print(){
            System.out.println(" printing somethingi n C");
        }
    }

    public static class ABC implements C{
//        public void log(){
//            System.out.println("ello");
//        }
//
        public void print(){
            System.out.println("printing in class");
        }
    }

    public static class K implements A{}
    public static void main(String args[]){

        C c = new ABC();
        c.log();
        C.print();
        ABC a = new ABC();
        a.print();

//
    }
}
