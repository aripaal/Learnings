package com.mylearnings.challenges;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ronnie on 5/1/17.
 */
public class MaxProfit {

    public static void main(String... args){

        Integer[] dayProfit = {-2,-5,10,3,2,4,-1,-3,4,-10,3};

        List<Integer> dayPrices= Arrays.asList(dayProfit);
        List<Days> daysList = new LinkedList<>();
        for(int i=0;i<dayPrices.size();i++){
            for(int j=i+1;j<dayPrices.size();j++){
                daysList.add(new Days(i,j,calculate(i,j,dayPrices)));
            }
        }

        ;

        System.out.println("Max profit on :"+Collections.max(daysList,(o1,o2)->o1.total-o2.total));

        System.out.println("max profit "+maxProfit(dayPrices));
    }

    public static int calculate(int start, int end, List<Integer> list){
        int sum=0;
        sum=Math.abs(list.get(start)-list.get(end));
        return sum;

    }

    public static int maxProfit(List<Integer> prices){
        if(prices==null||prices.size()<=1)
            return 0;

        int min=prices.get(0); // min so far
        int result=0;

        for(int i=1; i<prices.size(); i++){
            result = Math.max(result, prices.get(i)-min);
            min = Math.min(min, prices.get(i));
        }

        return result;
    }

    public static class Days{
        int start,end,total;

        public Days(int start, int end, int total) {
            this.start = start;
            this.end = end;
            this.total = total;
        }

        @Override
        public String toString() {
            return "Days{" +
                    "startDay=" + (start+1) +
                    ", endDay=" + (end+1) +
                    ", total=" + total +
                    '}';
        }
    }


}
