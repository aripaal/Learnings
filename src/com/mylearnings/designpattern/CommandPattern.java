package com.mylearnings.designpattern;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ronnie on 4/4/17.
 */
public class CommandPattern {

    public static class Stock{
        int value;

        public Stock(int value) {
            this.value = value;
        }

        public void sellStock(){
            System.out.println("selling stock value "+value);
        }
        public void buyStock(){
            System.out.println("buying stock value "+value);
        }
    }

    interface Order{
        void execute();
    }

    public static class BuyOrder implements Order{

        Stock s;

        public BuyOrder(Stock s) {
            this.s = s;
        }

        @Override
        public void execute() {
            s.buyStock();
        }
    }
    public static class SellOrder implements Order{
        Stock s;

        public SellOrder(Stock s) {
            this.s = s;
        }

        @Override
        public void execute() {
            s.sellStock();
        }
    }



    public static void main(String args[]) {
        Stock s1 = new Stock(12);
        Stock s2 = new Stock(34);
        List<Order> orders = new ArrayList<>();
        orders.add(new BuyOrder(s1));
        orders.add(new SellOrder(s2));
        for(Order o:orders)
            o.execute();
    }
}
