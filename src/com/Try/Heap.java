package com.Try;

import java.util.Arrays;

public class Heap {
   private int Max_Size = 1;
   private int last = -1;
   private int[] arr;
   private boolean Type = true;

   public Heap(){}

   public Heap(int size){
       this.Max_Size = size;
   }

   public Heap(boolean type){
       this.Type = type;
   }

   public Heap(int size,boolean type){
       this.Type = type;
       this.Max_Size = size;
   }

   public boolean empty(){
       return last == 0;
   }

   public int size(){
       return last;
   }

   public int top(){
       if(this.empty())return Integer.MIN_VALUE;
       return arr[0];
   }
   private int[] duplicate(int[] array){
       int[] newArray = new int[array.length*2];
       if(Type)Arrays.fill(newArray,Integer.MIN_VALUE);
       else Arrays.fill(newArray,Integer.MAX_VALUE);
       for(int i=0 ; i < array.length ; i++){
           newArray[i] = array[i];
       }
       return newArray;
   }
   public void insert(int data){
       if(this.empty()){
           arr = new int[Max_Size];
           arr[0] = data;
           last = 1;
           return;
       }

       if(Max_Size <= last){
           arr = duplicate(arr);
           Max_Size *= 2;
       }

       if (Type == true) {
           int parent = (last - 1) / 2, idx = last;
           while (parent > -1) {
               if (idx != 0 && arr[parent] < data) {
                   arr[idx] = arr[parent];
               } else {
                   arr[idx] = data;
                   break;
               }
               idx = parent;
               parent = (idx - 1) / 2;
           }
           last++;
           return;
       } else {
           int parent = (last - 1) / 2, idx = last;
           while (parent > -1) {
               if (idx != 0 && arr[parent] > data) {
                   arr[idx] = arr[parent];
               } else {
                   arr[idx] = data;
                   break;
               }
               idx = parent;
               parent = (idx - 1) / 2;
           }
           last++;
           return;
       }
   }
   public int pop(){
        int peak = arr[0];
        if(!this.empty())arr[0] = arr[last-1];
        else {
            last = 0;
            return arr[0];
        }
        int left = 1,right = 2,idx = 0;
        if( Type == true){
            arr[last - 1] = Integer.MIN_VALUE;
            while(idx < last/2){
                if(arr[left] > arr[right]){
                    if( arr[idx] < arr[left]){
                        int swap = arr[idx];
                        arr[idx] = arr[left];
                        arr[left] = swap;
                    }
                    idx = left;
                }
                else{
                    if(arr[idx] < arr[right]){
                        int swap = arr[idx];
                        arr[idx] = arr[right];
                        arr[right] = swap;
                    }
                    idx = right;
                }
                left = 2 * idx + 1;
                right = 2 * idx + 2;
            }
        }

        else{
            arr[last-1] = Integer.MAX_VALUE;
            while(idx < last/2){
                if(arr[left] < arr[right]){
                    if( arr[idx] > arr[left]){
                        int swap = arr[idx];
                        arr[idx] = arr[left];
                        arr[left] = swap;
                    }
                    idx = left;
                }
                else{
                    if(arr[idx] > arr[right]){
                        int swap = arr[idx];
                        arr[idx] = arr[right];
                        arr[right] = swap;
                    }
                    idx = right;
                }
                left = 2 * idx + 1;
                right = 2 * idx + 2;
            }
        }
        last--;
        return peak;
   }
}
