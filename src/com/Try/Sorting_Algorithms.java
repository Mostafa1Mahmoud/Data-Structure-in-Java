package com.Try;

import java.util.Stack;

public class Sorting_Algorithms {
    public static int[] Buble_sort(int[] array,int size){ //O(N^2) Comparisons & Swaps
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(array[i]>array[j]){
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }
    public static int[] Selection_sort(int[] array,int size){ // O(N) Swaps & O(N^2) Comparisons
        for(int i=0;i<size;i++){
            int min=Integer.MAX_VALUE,index=-1;
            for(int j=i+1;j<size;j++) {
                if (min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            if(index==-1)continue;
            int temp=array[index];
            array[index]=array[i];
            array[i]=temp;
        }
        return array;
    }
    public static int[] Insertion_sort(int[] array,int size){//O(N^2)Comparison & Copies
        for(int i=1;i<size;i++){
            int temp=array[i],x=i;
            for(int j=i;j>0&&temp<array[j-1];j--,x--){
                array[j]=array[j-1];
            }
            array[x]=temp;
        }
        return array;
    }
    public static int[] merge(int[] first,int sizef,int[] second,int sizes){
        int[] array=new int[sizef+sizes];
        int f=0,s=0;
        while(f<sizef&&s<sizes){
            if(first[f]<=second[s]){
                array[f+s]=first[f++];
            }
            else if(first[f]>=second[s]){
                array[f+s]=second[s++];
            }
        }
        if(s==sizes)while(f<sizef)array[s+f]=first[f++];
        if(f==sizef)while(s<sizes)array[s+f]=second[s++];
        return array;
    }
    public static void Merge_sort(int[] array,int l,int r){
        if(l==r)return;
        int mid=(r-l)/2+l;
        Merge_sort(array,mid+1,r);
        Merge_sort(array,l,mid);
    }
    public static void foo(Stack<Integer> s){
        int top=s.pop();
        foo(s);
        if(top>=0)s.push(top);
    }
    public static String reverese(int n){
        if(n==1)return "1";
        int r=n%2;
        String s =reverese(n/2);
        s+=Integer.toString(r);
        return s;
    }
    public static void reverseDisplay(String value,int index){
        if(index>=value.length())return;
        reverseDisplay(value,index+1);
        System.out.print(value.charAt(index));
    }

}
