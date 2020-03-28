package com.mylearnings.designpattern;

import com.mylearnings.others.Circle;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ronnie on 4/30/17.
 */
public class PrototypeDP {
    static class Shape implements Cloneable{
        @Override
        public Object clone(){
            Object clone=null;
            try {
                clone=super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return clone;
        }
    }

    static class Rectangle extends Shape{

    }
    static class Circle extends Shape{}
    static class Protoype {
        Map<Integer, Shape> cloneMap;

        public Protoype() {
            cloneMap=new HashMap<>();
        }

        public void loadCache(){

            cloneMap.put(1,new Circle());
            cloneMap.put(2,new Rectangle());

        }

        public Object getObject(Integer type){

            return cloneMap.get(type).clone();
        }

    }

    public static void main(String... args){

        Protoype p = new Protoype();
        p.loadCache();
        Circle c= (Circle)p.getObject(1);
        Rectangle r = (Rectangle) p.getObject(2);

    }

}
