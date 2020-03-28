package com.mylearnings.others;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ronnie on 3/30/17.
 */
public class CollectionExample

{

    public static void main(String args[]){

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(2);
//        for(int i=0;i<list.size();i++){
//            if(list.get(i)==2){
//                list.remove(i);
//            }
//        }
//        int count=0;
//        for(Integer i:list) {
//            ++count;
//            if (i == 2)
//                list.remove(count);
//        }

        Iterator<Integer> it=list.iterator();
        while(it.hasNext()){
            if(it.next()==2)
                it.remove();
        }
        list.forEach(System.out::println);

    }

}
