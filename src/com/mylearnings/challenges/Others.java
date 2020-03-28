package com.mylearnings.challenges;

import java.util.*;

/**
 * Created by ronnie on 5/1/17.
 */
public class Others {
    //abcdaadna
    public static String longestSubStringNoRepeat(String str){
        Set<Character> unique=new HashSet<>();
        String max="";
        for(int i=0;i<str.length();i++) {
            if (!unique.contains(str.charAt(i))) {
                unique.add(str.charAt(i));
            }
            else{
                String word = "";
                for (Character c : unique)
                    word += c;
                max = max.length() < word.length() ?
                        word : max;
                unique.clear();
            }

        }


        return max;
    }


    public static Integer findKLargest(List<Integer> list, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);

        for(Integer num:list){
            queue.offer(num);

            if(queue.size()>k)
                queue.poll();
        }

        return queue.peek();
    }

    public static int lengthOfLastWord(String sentence){
        String[] words=sentence.split(" ");

        int totalWords=words.length;
        if(totalWords==0)
            return 0;

        return words[words.length-1].length();


    }

}
