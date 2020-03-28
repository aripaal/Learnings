package com.mylearnings.mathproblems;

/**
 * Created by ronnie on 3/29/17.
 */
public class MathProblem {

    public static int reverseInteger(int value){

        int returnValue=0,pow=0,tempValue;
        tempValue=value;
        while(tempValue!=0){
            tempValue/=(int)Math.pow(10,++pow);
        }

        while(value!=0){
            returnValue+=(value%10)*(int)Math.pow(10,pow--);
            value/=10;

        }
        return returnValue;
    }




}
