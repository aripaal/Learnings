package com.mylearnings.cci;

import com.mylearnings.annotations.MyAnnotations;

import java.util.Arrays;

/**
 * Created by ronnie on 4/8/17.
 */
public class ArraysAndStrings {

    public boolean checkPermutation(String str1,String str2){
        char[] charArr1=str1.toCharArray();
        char[] charArr2=str2.toCharArray();
        Arrays.sort(charArr1);
        Arrays.sort(charArr2);
        return new String(charArr1).equalsIgnoreCase(new String(charArr2));
    }

//    public String replaceSpace(char[] original,int length){
//        int spaces=0;
//        //find number of spaces;
//        for(int i=0;i<length;i++)
//            if(original[i]==' ')
//                spaces++;
//
//        if(spaces==0)
//            return String.copyValueOf(original,0,length);
//
//        int newLength = length+ 2*spaces;
//        char[] temp = new char[10];
//        for(int j=length;j>0;j--){
//            temp
//            if(origi)
//
//        }
//
//    }

    public String stringCompression(String toCompress){
        //aaabbca-> a3b2c1a1
        char[] str = toCompress.toCharArray();
        String compressed ="";
        int compIndex=0;
        int count=1;
        char compare=str[0];
        for(int i=1;i<toCompress.length();i++){
            if(str[i]==compare){
                count++;
            }
            else{
                compressed=compressed+compare+count;
                compare=str[i];
                count=1;
            }


        }
        return compressed+compare+count;

    }

    public boolean checkUniqueCharacters(String value){
        char[] arr= value.toCharArray();
        //A_Z 65-90 & a_z 97-122

        boolean alphabet[] = new boolean[50];
        for(int i=0;i<arr.length;i++){
            int index=getCorrectedIndex(arr[i]);
            if(alphabet[index]==false){
                alphabet[index]=true;
            }
            else
                return false;
        }
        return true;
    }
    @MyAnnotations(authorName = "Arijit",revision = 2,comments = "finds the corrected index")
    private int getCorrectedIndex(char charValue){
        int index=(int)charValue;
        if(index>=65 & index <=90){
            return index-65;
        }
        else if(index>=97 & index <=122){
            return index -72;
        }
        return 52;

    }




}
