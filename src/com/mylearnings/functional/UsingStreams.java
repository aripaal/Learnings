package com.mylearnings.functional;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ronnie on 3/12/17.
 */
public class UsingStreams {
    public static void main(String args[]){
        Stream<Integer> s= Stream.of(1,2,3,3);
        Integer reduced=s.reduce(0,(s1,s2)->s1+s2);
        System.out.println(reduced);

        Stream<String> s1= Stream.of("a","b","c");
        StringBuilder s3=s1.collect(StringBuilder::new,(a,b)->a.append(b),(a,b)->a.append(b));
        System.out.println(s3);


        List<String> list = new LinkedList<>();
        list.add("ronnie");
        list.add("rekha");
        list.add("mona");
        list.add("pola");

        list.stream().filter(t->t.startsWith("r")).map(r->new StringBuilder(r).reverse().toString()).collect(Collectors.toList());

        List<LocalDate> dates = new LinkedList<>();
        dates.add(LocalDate.of(2014, Month.JUNE,12));
        dates.add(LocalDate.of(2014, Month.JULY,12));
        dates.add(LocalDate.of(2014, Month.AUGUST,12));
        dates.add(LocalDate.of(2014, Month.JUNE,11));

       // list.stream().collect(Collectors.toMap(t->(t)));
        dates.stream().filter(t-> t.isBefore(LocalDate.of(2014,Month.AUGUST,1))).sorted((c1,c2)->c2.compareTo(c1)).forEach(System.out::println);


    }



}
