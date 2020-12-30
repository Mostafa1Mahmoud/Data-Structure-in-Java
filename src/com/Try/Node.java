package com.Try;
/*
 *
 * This Code was Written By Eng : Mostafa Mahmoud Mostafa
 *
 * */
public class Node {
    private int value;
    public Node next;
    public Node(){}
    public Node(int value){
        this.value=value;
    }
    public int get_value(){
        return this.value;
    }
    public void set_value(int value){
        this.value=value;
    }
}
