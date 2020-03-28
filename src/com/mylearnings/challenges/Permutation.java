package com.mylearnings.challenges;

/**
 * Created by ronnie on 5/1/17.
 */
public class Permutation {

 public static void permute(String str){
     permute("","abc");
 }

 public static void permute(String prefix,String str){
     int n = str.length();
     if(n==0)
         System.out.println(prefix);
     else
         for(int i=0;i<n;i++){
             System.out.println("i:"+i+",prefix:"
                     +prefix+",charat:"+str.charAt(i)

             );
             permute(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1,n));
         }
 }
    public static void main(String... args){
        permute("abc");
    }
}
