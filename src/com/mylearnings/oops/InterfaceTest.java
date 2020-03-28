package com.mylearnings.oops;

/**
 * Created by ronnie on 4/14/17.
 */
public class InterfaceTest {
    public class Mammal{
        public void identify(){
            System.out.println("I am a Mammal");
        }
    }
    interface Animal{

        default void identify(){
            System.out.println("I am an Animal");
        }
    }
    interface Cat extends Animal{
        default void identify(){
            System.out.println("I am a Cat");
        }
    }

    interface Feline extends Animal{
//        default void identify(){
//            System.out.println("I am a Feline");
//        }
    }

    public class Tiger extends Mammal implements Cat,Feline{
//        public void identify(){
//            System.out.println("I am a Tiger");
//        }

    }


    interface A{
        default void dostuff(){
            System.out.println("doing A stuff");
        }

    }

    interface B{
//        default void dostuff(){
//            System.out.println("doing B stuff");
//        }
        void dostuff();
    }

    interface C extends B{

    }
    public static class CC{
       public void dostuff(){
            System.out.println("doing A stuff");
        }
    }


    public static class ZZ{
        public static void doThat(){

        }
    }
    public static class ZX extends ZZ{
//        public void doThat(){
//
//        }
    }
    public static class CA extends CC implements B{

    }
    public static void main(String args[]){

        InterfaceTest.Tiger t = new InterfaceTest().new Tiger();
        t.identify();

    }
}
