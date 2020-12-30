package com.Try;

public class stack {
    public Node top;
    public stack(){}
    public stack(int value){
        top = new Node(value);
    }
    public boolean empty(){
        return top==null;
    }
    public int top(){
        if(this.empty())return -1;
        return top.get_value();
    }
    public void push(int value){
        if(this.empty()){
            top=new Node(value);
            return;
        }
        Node node = new Node(value);
        node.next=top;
        top=node;
    }
    public void pop(){
        if(this.empty())return;
        top=top.next;
    }
}
