package com.mylearnings.functional;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.*;


/**
 * Created by ronnie on 3/11/17.
 */
public class FunctionalExample {
    @FunctionalInterface interface QuadFunction<T,U,V,W,R>{
        R apply(T t,U u,V v,W w);
    }
    static class Sum{
        Integer value=0;
        public void addValue(Integer x){
            value+=x;
        }
        public Integer getValue(){
            return value;
        }
    }
    public static Optional<Integer> avg(Integer... value){
        int size = value.length;
        Sum s=new Sum();
        List<Integer> abc = new ArrayList<>();
        Arrays.asList(value).forEach(abc::add);


        return Optional.ofNullable(s.getValue());
        
        
    }
    public static void print(Integer val){
        System.out.println(val);
    }
    public static void main(String args[]){
        Consumer<Integer> a1 = a-> System.out.println(a+1);
        a1.accept(12);

        Supplier<Integer> a2 = ()-> 34;
        System.out.println(a2.get());

        BiConsumer<String,String> a3 =  (u,v)-> System.out.println("Hello "+u+" "+v);
        a3.accept("Arijit","Pal");

        List<Integer> lists = new ArrayList<>();
        Consumer<Integer> listFilter = a->{
            if(a<10){
                lists.add(a);
            }
            else throw new IllegalArgumentException("Invalid value");
        };

            listFilter.accept(4);
           // listFilter.accept(90);
            listFilter.accept(9);

        lists.forEach(System.out::println);

        Predicate<Integer> isHigherThan10 = a->a>10;

        lists.add(10);
        lists.add(56);
        System.out.println("--------");
        lists.forEach(a-> {
            if(isHigherThan10.test(a)){
                System.out.println(a);
            }


            }
        );

        Function<String,Integer> getPositionOfA = t-> {
            String rev = new StringBuffer(t).reverse().toString();
            return rev.length()-t.indexOf('a')+1;

        };
        System.out.println("Index of a in ohama:"+ getPositionOfA.apply("ohama"));

        QuadFunction<String,String,String,String,String> funct = (t,u,v,w)-> t+u+v+w;

        System.out.println(funct.apply("Hello","I","am","John"));
        System.out.println("--------");
        Optional<Integer> optional = avg(1,4,5,6);
        optional.ifPresent(System.out::println);


        lists.stream().filter(t->t>10).forEach(System.out::println);

    }


}
