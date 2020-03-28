package com.mylearnings.collectionspack;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ronnie on 3/10/17.
 */
public class UsingSortedSet {
    static class Rabbit{
        String name;
        int id;

        public Rabbit(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Rabbit{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }


    public static void main(String args[]){

        Rabbit a = new Rabbit("bobo",1);
        Rabbit b = new Rabbit("pola",2);
        Rabbit c = new Rabbit("katoush",5);

        Set<Rabbit> rabbits = new HashSet<>();
        rabbits.add(a);
        rabbits.add(b);
        rabbits.add(c);
        System.out.println(rabbits);
        rabbits = new TreeSet<>((r1,r2)-> r1.getName().compareTo(r2.getName()));
        rabbits.add(b);
        rabbits.add(a);
        rabbits.add(c);
        System.out.println(rabbits);

    }

}
