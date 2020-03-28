package com.mylearnings.others;

/**
 * Created by ronnie on 4/12/17.
 */
public class Circle {
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Circle circle = (Circle) o;
//
//        return radius == circle.radius;
        return super.equals(o);
    }

    public boolean objEquals(Object o){
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return radius;
    }
}
