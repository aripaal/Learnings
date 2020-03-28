package com.mylearnings.generics;

/**
 * Created by ronnie on 3/10/17.
 */
public class Swap<T> {
    T x;
    T y;

    public Swap(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public  void swap(){
        T temp = y;
        y=x;
        x=temp;

    }

    public T getX() {
        return x;
    }

    public T getY() {

        return y;
    }

    public static void main(String args[]){
        Swap<String> abc = new Swap<>("man","united");
        System.out.println(abc.getX()+"|"+abc.getY());
        abc.swap();
        System.out.println(abc.getX()+"|"+abc.getY());

        Swap<Integer> def = new Swap<>(123,456);
        System.out.println(def.getX()+"|"+def.getY());
        def.swap();
        System.out.println(def.getX()+"|"+def.getY());


    }



}
