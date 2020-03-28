package com.mylearnings.designpattern;

/**
 * Created by ronnie on 4/5/17.
 */
public class StrategyPattern {

   interface Strategy{
       int doOperationt(int num1,int num2);
   }

   public static class AddOperation implements Strategy{

       @Override
       public int doOperationt(int num1, int num2) {
           return num1+num2;
       }
   }

   public static class Context{
       int num1,num2;

       public Context(int num1, int num2) {
           this.num1 = num1;
           this.num2 = num2;
       }
       public int getValue(Strategy s){
           return s.doOperationt(num1,num2);
       }
   }

   public static void main(String... args){
       Context c1 = new Context(2,3);
       System.out.println(c1.getValue(new AddOperation()));
   }

}
