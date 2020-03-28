package com.mynew.learnings.lambdas;

/**
 * Created by ronnie on 7/31/17.
 */
public class Persons {
    private String name;
    private Integer age;

    public Persons(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
