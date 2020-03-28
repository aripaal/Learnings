package com.mylearnings.mathproblems;

/**
 * Created by ronnie on 3/30/17.
 */
public class genericProblem {

    public boolean isUnique(String word){

        for(int i=0;i<word.length();i++){
            Character toCheck = word.charAt(i);
            for(int j=0;j<word.length();j++){
                if(j==i)
                    continue;
                if(toCheck==word.charAt(j))
                    return false;

            }

        }
        return true;

    }



}
