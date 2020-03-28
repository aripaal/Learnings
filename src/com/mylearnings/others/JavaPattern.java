package com.mylearnings.others;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ronnie on 3/29/17.
 */
public class JavaPattern {
    static String sentence="I am Long John Silver!! I am";

    public static void main(String args[]){
       Pattern pattern = Pattern.compile("am");
       Matcher matcher= pattern.matcher(sentence);
       int val=0;
       while(matcher.find()){

           System.out.println(matcher.group());
       }
        System.out.println(val);
       String replaced= matcher.replaceAll("soam");
        System.out.println(replaced);
       pattern=Pattern.compile(" ");
       matcher = pattern.matcher(sentence);
       String[] arr = sentence.split("\\n");
        System.out.println(arr.length);
        List<String> arrList = Arrays.asList(arr);
        arrList.forEach(System.out::println);

    }


}
