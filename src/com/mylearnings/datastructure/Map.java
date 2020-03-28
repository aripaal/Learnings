package com.mylearnings.datastructure;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by ronnie on 4/8/17.
 */
public class Map<K,V> {
    int MAX_VALUE=5;
    int size=0;
    Entry<K,V> []entries = new Entry[MAX_VALUE];
    public int getArraySize(){
        return MAX_VALUE;
    }
    public V get(K key){
        for(int i=0;i<size;i++){
            if(entries[i].getKey()==key)
                return entries[i].getValue();
        }
        return null;
    }

    public V put(K key,V value){
        for(int i=0;i<size;i++){
            if(entries[i].getKey().equals(key)){
                V temp = entries[i].getValue();
                entries[i].setValue(value);
                return temp;
            }
        }
        resize();
        entries[size++]=new Entry<>(key,value);
        return null;
    }

    private void resize(){
        if(size >= 0.75 * MAX_VALUE){
            entries=Arrays.copyOf(entries,2 * MAX_VALUE);
            MAX_VALUE=MAX_VALUE*2;
        }

    }


    public static class Entry<K,V>{

        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public V getValue() {
            return value;
        }
    }

}
