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
    public static int[] Insertion_sort(int[] array){//O(N^2)Comparison & Copies
        for(int i = 1;i < array.length;i++){
            int j = i,val = array[i];
            while(j > 0 && val < array[j-1]){
                array[j] = array[j-1];
                j--;
            }
            array[j] = val;
        }
        return array;
    }
    public static int[] Merge(int array[],int l, int mid,int r){
        int sz1 = mid - l + 1;
        int sz2 = r -mid;
        int L[] = new int[sz1];
        int R[] = new int[sz2];
        for(int i = 0;i < sz1;i++)L[i] = array[l+i];
        for(int i = 0;i < sz2;i++)R[i] = array[mid+i+1];
        int i = 0, j = 0;
        int k = l;
        while (i < sz1 && j < sz2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            }
            else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < sz1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < sz2) {
            array[k] = R[j];
            j++;
            k++;
        }
        return array;
    }
    public static int[] Merge_sort(int[] array,int l,int r){
        if(l==r)return null;
        int mid=(r-l)/2+l;
        Merge_sort(array,mid+1,r);
        Merge_sort(array,l,mid);
        return Merge(array,l,mid,r);
    }
     public static int[] Shell_sort(int [] array){
        int gap = 1;
        while(gap <= array.length/3)gap = 3*gap+1;
         for(;gap > 0;gap /= 2) {
             for (int i = gap; i < array.length; i++) {
                 int val = array[i],j = i;
                 for(;j >= gap && array[j - gap] > val;j-=gap)array[j] = array[j - gap];
                 array[j] = val;
             }
         }
        return array;
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
