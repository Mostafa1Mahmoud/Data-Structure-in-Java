package com.Try;

public class link {
    private int data;
    public link next;
    public link pre;
    public link(){}
    public link(int data){
        this.data=data;
    }
    public int get_data(){
        return this.data;
    }
    public void set_data(int data){
        this.data=data;
    }
}
