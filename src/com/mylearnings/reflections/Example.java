package com.mylearnings.reflections;

/**
 * Created by ronnie on 5/9/17.
 */
public class Example {
    private String word;
    public String gogo;
    public Example(String word){
        this.word=word;
    }
    private Example(){
        this.word="dodo";
    }
    private void method(){
        System.out.println(word);
    }
    private void saySomething(String value){
        System.out.println(value);
    }
    public void method(String word){
        this.word+=" "+word;
        System.out.println(this.word);
    }

}
