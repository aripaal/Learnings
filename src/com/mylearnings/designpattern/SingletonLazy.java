package com.mylearnings.designpattern;

/**
 * Created by ronnie on 3/10/17.
 */
public class SingletonLazy {
    private int number;

    private static SingletonLazy instance;

    public static SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();

                }
            }
        }
        return instance;
    }


    public synchronized void setNumber(int number){
        this.number=number;
    }
    public synchronized int getNumber(){
        return this.number;
    }

    public static void main(String args[]){

        SingletonLazy s1 = SingletonLazy.getInstance();
        SingletonLazy s2 = SingletonLazy.getInstance();

        s1.setNumber(46);
        System.out.println("s1:"+s1.getNumber()+" s2:"+s2.getNumber());


    }


}
