package com.mylearnings.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ronnie on 3/10/17.
 */
public class Animal {
    static class Feline{}
    static class Cat extends Feline{}

    public void size(List<? extends Feline> list){
        System.out.println(list.size());

    }


    public static void main(String args[]){
        List<Cat> cats = new LinkedList<>();
        cats.add(new Cat());
        cats.add(new Cat());

        Animal a = new Animal();
        a.size(cats);


    }


}
