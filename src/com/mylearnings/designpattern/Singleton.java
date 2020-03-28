package com.mylearnings.designpattern;

/**
 * Created by ronnie on 3/10/17.
 */
public class Singleton {

    private int number;

    private Singleton(){}

    private static final Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }

    public synchronized void setNumber(int number){
        this.number=number;
    }
    public synchronized int getNumber(){
        return this.number;
    }

    public static void main(String args[]){

        Singleton s1= Singleton.getInstance();
        Singleton s2=Singleton.getInstance();
        s1.setNumber(34);
        System.out.println("s1:"+s1.getNumber()+" s2:"+s2.getNumber());


    }

}
