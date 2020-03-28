package com.mylearnings.functional;


import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ronnie on 3/13/17.
 */
public class UsingStreams2 {

    public static void main(String args[]){
        Stream<Integer> s1 = Stream.of(1,2,3,4,5,6,7,8,9);

        //System.out.println(s1.max((c1,c2)->c1.compareTo(c2)).get());
        //System.out.println(s1.noneMatch(c->c>5));

        //System.out.println(s1.findFirst());
       // System.out.println(s1.reduce(1,(a,b)->a*b));
          s1.filter(c->c<6).map(c->c+1).forEach(System.out::println);

        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Sam",1));
        employees.add(new Employee("Sam",100));
        employees.add(new Employee("Smith",2));
        employees.add(new Employee("Neil",4));
        employees.add(new Employee("Trinity",6));

        Stream<Employee> employeeStream = employees.stream();
        employeeStream.filter(e-> e.getId()<=4).map(e->{ e.addComp(20.0d); return e.getComp();}).count();

        Stream<Employee> employeeStream1 = employees.stream();
        Map<Boolean,List<Employee>> maps = employeeStream1.collect(Collectors.partitioningBy(e->e.getComp()>100));
        employees.forEach(System.out::println);

        System.out.println("Employees who are happy");
        maps.get(true).forEach(System.out::println);

        Stream<Employee> employeeStream2 = employees.stream();
        System.out.println(employeeStream2.filter(e-> e.getId()<=4).collect(Collectors.mapping(e->{ e.addComp(20.0d); return e.getComp();}, Collectors.counting())));
        employees.forEach(System.out::println);

    }

    static class Employee{
        private String name;
        private long id;
        private double comp;



        public Employee(String name, long id) {
            this.name = name;
            this.id = id;
            comp=100.0d;
        }

        public String getName() {
            return name;
        }

        public long getId() {
            return id;
        }
        public void addComp(double increment){
            comp+=increment;
        }
        public double getComp(){
            return comp;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    ", comp=" + comp +
                    '}';
        }
    }
    }



