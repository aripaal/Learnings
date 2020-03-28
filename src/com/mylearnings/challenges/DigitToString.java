package com.mylearnings.challenges;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ronnie on 5/1/17.
 */
public class DigitToString {



    public static class Convert{
        Map<Integer,String> converter = new HashMap<>();
        Convert(){
            loadCache();
        }
        public void loadCache(){
            converter.put(1,"One");
            converter.put(2,"Two");
            converter.put(3,"Three");
            converter.put(4,"Four");
            converter.put(5,"Five");
            converter.put(6,"Six");
            converter.put(7,"Seven");
            converter.put(8,"Eight");
            converter.put(9,"Nine");
            converter.put(10,"Ten");
            converter.put(11,"Eleven");
            converter.put(12,"Twelve");
            converter.put(13,"Thirteen");
            converter.put(14,"Fourteen");
            converter.put(15,"Fifteen");
            converter.put(16,"Sixteen");
            converter.put(17,"Seventeen");
            converter.put(18,"Eighteen");
            converter.put(19,"Nineteen");
            converter.put(20,"Twenty");
            converter.put(30,"Thirty");
            converter.put(40,"Forty");
            converter.put(50,"Fifty");
            converter.put(60,"Sixty");
            converter.put(70,"Seventy");
            converter.put(80,"Eighty");
            converter.put(90,"Ninety");
            converter.put(100,"Hundred");
            converter.put(1000,"Thousand");
        }

        public  void convert(String value){
            int len=value.length();
            int pos=len-1;
            for(int i=0;i<len;i++){
                int digit=Integer.valueOf(""+value.charAt(i));
                if(pos>1){
                    System.out.print(converter.get(digit)+converter.get((int)Math.pow(10,pos)));
                }
                else if(pos==1){
                    if(digit==1){
                        int tensDigit=Integer.valueOf(value.substring(i,len));
                        System.out.print(converter.get(tensDigit));
                        break;
                    }else {
                        System.out.print(converter.get(digit * 10));
                    }
                }else {
                    System.out.print(converter.get(digit));
                }
                --pos;
            }




        }

        public static void main(String... args){

            Convert converter=new Convert();
            converter.convert("4422");

        }




    }
}
