package com.mylearnings.designpattern;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ronnie on 5/11/17.
 */
public class FilterPattern {

    public static class Person{
        String name;
        int age;
        char sex;

        public Person(String name, int age, char sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public char getSex() {
            return sex;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex=" + sex +
                    '}';
        }
    }
    interface Criteria{
        List<Person> meetCriteria(List<Person> people);
    }
    static class MaleCriteria implements Criteria{

        @Override
        public List<Person> meetCriteria(List<Person> people) {
            return people.stream().filter(p->p.getSex()=='M').collect(Collectors.toList());
        }
    }


    public static void main(String... args){
        MaleCriteria maleCriteria= new MaleCriteria();
        List<Person> people=new LinkedList<>();
        people.add(new Person("Arijit",33,'M'));
        people.add(new Person("Naman",39,'M'));
        people.add(new Person("Swathi",30,'F'));
        people.add(new Person("Rekha",56,'F'));
        people.add(new Person("Jamal",27,'M'));
        people.add(new Person("Lokesh",88,'M'));
        people.add(new Person("Garibh",22,'M'));

        maleCriteria.meetCriteria(people).forEach(System.out::println);
        Criteria c = new Criteria() {
            @Override
            public List<Person> meetCriteria(List<Person> people) {
                return people.stream().filter(p->p.getAge()>30).collect(Collectors.toList());
            }
        };

        c.meetCriteria(people).forEach(System.out::println);
    }
}
