package com.Try;

public class deque {
    public Node head;
    public Node tail;
    public Node pre;
    public deque(){}
    public deque(int value){
        head=tail=new Node(value);
    }
    public boolean empty(){
        return head==null&&tail==null;
    }
    public int front(){
        if(this.empty())return -1;
        return head.get_value();
    }
    public int back(){
        if(this.empty())return -1;
        return tail.get_value();
    }
    public void push_front(int value){
        if(this.empty()){
            head = tail = new Node(value);
            return;
        }
        Node node = new Node(value);
        node.next=head;
        head=node;
    }
    public void pop_front(){
        if(this.empty())return;
        if(head==tail){
            head=tail=null;
            return;
        }
        head=head.next;
    }
    public void push_back(int value){
        if(this.empty()){
            head = tail = new Node(value);
            return;
        }
        Node node = new Node(value);
        tail.next=node;
        pre=tail;
        tail=node;
    }
    public void pop_back(){
        if(this.empty())return;
        if(head==tail){
            head=tail=null;
            return;
        }
        pre.next=null;
    }
}
