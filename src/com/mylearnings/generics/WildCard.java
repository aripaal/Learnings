package com.mylearnings.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ronnie on 4/23/17.
 */
public class WildCard {

    public static class Box<T>{
        T t;
        List<Box<? extends T>> list = new LinkedList<>();
        public Box(T t) {
            this.t = t;
        }

        public void show(Box<? extends T> t){
            System.out.println("value->"+t);
        }
        public void add(Box<? extends T> t){
            list.add(t);
        }

        @Override
        public String toString() {
            return "Box{" +
                    "t=" + t +
                    '}';
        }
    }


    public static void main(String... args){
        Box<Number> box=new Box<>(2);
//        box.show(new Box<Integer>(1));
//        box.show(new Box<Double>(1.0));
        box.add(new Box<Integer>(1));
        box.add(new Box<Double>(1.0));
        box.list.forEach(System.out::println);


        List<Box<? extends Number>> boxList= new LinkedList<>();
        boxList.add(new Box<Number>(1));


        List<? super Number> numList = new LinkedList<>();
        numList.add(new Integer(1));
        numList.add(new Float(3.0));
        numList.forEach(System.out::println);
    }

}
