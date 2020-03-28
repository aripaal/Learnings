package com.mylearnings.designpattern;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ronnie on 4/30/17.
 */
public class VisitorDP {

   interface ItemParts{
      void accept(Visitor v);
   }

   public static class Keyboard implements ItemParts{
       @Override
       public void accept(Visitor v) {
           v.visit(this);
       }
   }
   public static class Monitor implements ItemParts{
       @Override
       public void accept(Visitor v) {
           v.visit(this);
       }
   }
   public static class Computer implements ItemParts{
       List<ItemParts> parts = Arrays.asList(new Monitor(),new Keyboard());
       @Override
       public void accept(Visitor v) {
            for(ItemParts p:parts)
                p.accept(v);
            v.visit(this);
       }
   }
   interface Visitor{
       void visit(Keyboard k);
       void visit(Monitor m);
       void visit(Computer c);
   }
   public static class ComputerVisitor implements Visitor{

       @Override
       public void visit(Keyboard k) {
           System.out.println("key");
       }

       @Override
       public void visit(Monitor m) {
           System.out.println("monitor");
       }

       @Override
       public void visit(Computer c) {
           System.out.println("computer");
       }
   }
   public static void main(String... args){
       Computer computer=new Computer();
       computer.accept(new ComputerVisitor());
   }
}
