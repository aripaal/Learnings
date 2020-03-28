package com.mylearnings.sorting;

public class QuickSelect {

    private int[] arr;

    public QuickSelect(int[] unsorted) {
        this.arr = unsorted;
    }

    private void swap(int from,int to){
        int temp=arr[to];
        arr[to]=arr[from];
        arr[from]=temp;
    }

    private int getPivot(int beg,int end){
        int firstIndx=beg;
        int med=(beg+end)/2;
        swap(med,end);

        for(int i=firstIndx;i<end;i++){
            if(arr[i]>arr[end]){
                swap(i,firstIndx);
                firstIndx++;
            }
        }
        swap(firstIndx,end);
        return firstIndx;
    }
    public int select(int k){
        return select(k-1,0,arr.length-1);
    }
    public int select(int k, int start, int end){

        int pivot = getPivot(start,end);

        if(k<pivot){
            select(k,0,pivot-1);
        }
        else if(k>pivot){
            select(k,pivot+1,arr.length-1);
        }

            return arr[k];
    }

   public static void main(String... args){
       QuickSelect qs=new QuickSelect(new int[]{1,-2,5,8,7,6});
       System.out.println(qs.select(2));
   }
}
