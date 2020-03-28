package com.mylearnings.functional;

import java.util.function.Predicate;
/**
 * Created by ronnie on 3/9/17.
 */
public class MyFunctional {
    String name;
    int age;


    public MyFunctional(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean isTeen(){
        return age <20;
    }
    public boolean isSenior(){
        return age >60;
    }
    public boolean isMiddle(){
        return age >=20 & age <=60;
    }


    public void checkAge(Predicate<MyFunctional> a){
        if(a.test(this))
            System.out.println(this.name);

    }

    public static void main(String args[]){

        MyFunctional [] lists= {new MyFunctional("Smith",65),new MyFunctional("Jonas",45)};

        for(MyFunctional men: lists){
            men.checkAge(a->a.isSenior());
            men.checkAge(a->a.isMiddle());
        }

    }


}
