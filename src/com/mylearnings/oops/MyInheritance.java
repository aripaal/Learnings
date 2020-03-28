package com.mylearnings.oops;

/**
 * Created by ronnie on 4/14/17.
 */
public class MyInheritance {
    int x=10;

    public void testInnerfunction(){
        int var=3;
        class Inner{
            public void doSome(){
                System.out.println(var+MyInheritance.this.x);
            }



        }
        new Inner().doSome();


    }
    class InnerClass{
        int x=3;

        public void doSomthing(){
            System.out.println(x);
            System.out.println(InnerClass.this.x);
            System.out.println(MyInheritance.this.x);


        }
    }
public static void main(String args[]){


        MyInheritance.InnerClass innerClass=new MyInheritance().new InnerClass();
        innerClass.doSomthing();
        MyInheritance inheritance=new MyInheritance();
        inheritance.testInnerfunction();

}

}
