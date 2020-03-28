package com.mylearnings.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaStreams {
    public static void main(String... args){
        List<Integer> list = Arrays.asList(1,4,3,23,45,22,3,24,223,4);
        list.stream().map(t->t+1).forEach(System.out::println);

        List<Emp> emps = Arrays.asList(new Emp("Arijit",34),new Emp("Brian",65),new Emp("Rekha",56));
        Map<Integer,String> map= emps.stream().filter(t->t.age<40).collect(Collectors.toMap(t->t.age, t->t.name));
        System.out.println(map.get(34));
    }

    public static class Emp{
        private String name;
        private int age;

        public Emp(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
