package com.mylearnings;

import java.util.LinkedList;
import java.util.List;

public class Spiral {

    public static List<Integer> list = new LinkedList<>();
    public static void printSpiral(int[][]input){
        int l= input.length;
        boolean[][] visited = new boolean[l][l];
        int x=0,y=0;
        //going right x++
        for(int pos=0;pos<l;pos++){
            if(validatePosition(y,pos,visited)){
                list.add(input[y][pos]);
                x=pos;
            }
        }
        //going down y++
        for(int pos=0;pos<l;pos++){
            if(validatePosition(pos,x,visited)){
                list.add(input[pos][x]);
                y=pos;
            }
        }

        list.forEach(t->System.out.print(t+" "));

    }

    public void printPos(int staticPosition,int pos ,int[][] input,boolean[][] visited){
        //for(int )

    }

    public static boolean validatePosition(int i,int j, boolean[][]visited){
        if(!visited[i][j]){
            if(i>=0 && i<visited.length)
                if(j>=0 && j<visited.length) {
                    visited[i][j]=true;
                    return true;
            }
        }
        return false;
    }

    public static void main(String... args){

        int[][] input= new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        printSpiral(input);
    }

}
