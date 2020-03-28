package com.mylearnings.others;

/**
 * Created by ronnie on 4/4/17.
 */
public class CodingSolutions {

    public void reverseString(String s){

        if(s.length()==0)
            return;

        System.out.print(s.charAt(s.length()-1));

        reverseString(s.substring(0,s.length()-1));


    }

    public static void main(String args[]){

        CodingSolutions cs = new CodingSolutions();
        cs.reverseString("hello");
    }

}
