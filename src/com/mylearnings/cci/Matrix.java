package com.mylearnings.cci;

import java.util.Random;

/**
 * Created by ronnie on 4/9/17.
 */
public class Matrix {
    int length;
    char a[][];
    public Matrix(int length) {
        this.length = length;
        a= new char[length][length];
    }

    public void generate(){
        Random r = new Random();
        for(int i=0;i<length;i++)
            for(int j=0;j<length;j++)
                a[i][j]=(char)(r.nextInt(25)+97);


    }
    public void rotate(){
        char[][] rotated = new char[length][length];
        int iIndx=0,jIndx=length-1;
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
             rotated[i][j]=a[iIndx++][jIndx];

            }
            iIndx=0;
            --jIndx;
        }
        a=rotated;

    }
    public void makerowColumnZero(){
        for(int i=0;i<length;i++) {
            for (int j = 0; j < length; j++) {
                if(a[i][j]==0){
                    for(int indx=0;indx<length;indx++) {
                        a[indx][j] = 0;
                        a[i][indx] = 0;
                    }

                }

            }
        }


    }
    public void display(){
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++)
                System.out.print(a[i][j]+" ");
            System.out.println();
        }

    }


}
