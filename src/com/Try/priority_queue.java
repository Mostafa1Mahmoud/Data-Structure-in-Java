package com.Try;

public class priority_queue {
    public Node head;
    public priority_queue(){}
    public priority_queue(int value){
        head=new Node(value);
    }
    public boolean empty(){
        return head==null;
    }
    public int front(){
        if(this.empty())return -1;
        return head.get_value();
    }
    public void insert(int value){
        if(head==null){
            head=new Node(value);
            return;
        }
        Node node = new Node (value);
        Node temp=head, pre=head;
        while (temp != null && value > temp.get_value()){
            pre = temp;
            temp = temp.next;
        }
        if(temp==pre){
            node.next=head;
            head=node;
            return;
        }
        pre.next = node;
        node.next = temp;
    }
    public void pop(){
        if(this.empty())return;
        head=head.next;
    }
}
