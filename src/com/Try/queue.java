package com.Try;

public class queue {
    public Node head;
    public Node tail;
    public queue(){}
    public queue(int value){
        head=tail=new Node(value);
    }
    public boolean empty(){
        return head==null&&tail==null;
    }
    public void push(int value){
        if(this.empty()){
            head=tail=new Node(value);
            return;
        }
        Node node = new Node(value);
        tail.next=node;
        tail=node;
    }
    public void pop(){
        if(this.empty())return;
        if(head==tail){
            head=tail=null;
            return;
        }
        head=head.next;
    }
    public int front(){
        if(this.empty())return -1;
        return head.get_value();
    }
}
