package com.mylearnings.others;

import java.util.Iterator;

/**
 * Created by ronnie on 3/30/17.
 */
public class Box<T> implements Iterable<T> {


    @Override
    public Iterator<T> iterator(){
     return new BoxIterator<T>();
    }

    private static class BoxIterator<T> implements Iterator<T>{
        public T next(){

            return null;
        }

        public boolean hasNext(){
            return true;
        }

    }



}
