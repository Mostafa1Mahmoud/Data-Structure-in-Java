package com.Try;
/*
 *
 * This Code was Written By Eng : Mostafa Mahmoud Mostafa
 *
 * */
public class List {
    private Node root;
    public List(){}
    public List(int value){
        root=new Node(value);
    }
    public Node get_root(){
        return this.root;
    }
    public boolean empty(){
        return this.root==null;
    }
    public void print(){
        if(this.empty())return;
        Node temp=root;
        while(temp!=null){
            System.out.println(temp.get_value());
            temp=temp.next;
        }
    }
    public void push_front(int value){
        if(this.empty()){
            root = new Node(value);
            return;
        }
        Node node = new Node(value);
        node.next=root;
        root=node;
    }
    public void pop_front(){
        if(this.empty())return;
        root=root.next;
    }
    public void push_back(int value){
        if(this.empty()){
            root=new Node(value);
            return;
        }
        Node node = new Node(value),temp=root;
        while(temp.next!=null)temp=temp.next;
        temp.next=node;
    }
    public void pop_back(){
        if(this.empty())return;
        Node temp = root,pre=root;
        while(temp.next!=null) {
            pre = temp;
            temp = temp.next;
        }
        pre.next=null;
    }
    public void insert_sorted(int value){
        if(root==null){
            root=new Node(value);
            return;
        }
        Node node = new Node (value);
        Node temp=root, pre=root;
        while (temp != null && value > temp.get_value()){
            pre = temp;
            temp = temp.next;
        }
        if(temp==pre){
            node.next=root;
            root=node;
            return;
        }
        pre.next = node;
        node.next = temp;
    }
    public void add_by_index(int index,int value){
        if(this.empty()){
            root=new Node(value);
            return;
        }
        if(index==0){
            Node node =new Node(value);
            node.next=root;
            root=node;
            return;
        }
        Node temp=root,pre=root,node = new Node(value);
        int itr=0;
        while(temp!=null){
            if(itr==index){
                node.next=temp;
                pre.next=node;
                return;
            }
            pre=temp;
            temp=temp.next;
            itr++;
        }
        pre.next=node;
    }
    public void delete_by_value(int value){
        if(this.empty())return;
        if(root.get_value()==value){
            root=root.next;
            return;
        }
        Node temp = root,pre=root;
        while(temp!=null){
            if(temp.get_value()==value){
                pre.next=temp.next;
                return;
            }
            pre=temp;
            temp=temp.next;
        }
        return;
    }
    public void delete_by_index(int index){
        if(this.empty())return;
        if(index==1){
            root=root.next;
            return;
        }
        Node temp = root,pre=root;
        int itr=0;
        while(temp!=null){
            if(index==itr){
                pre.next=temp.next;
                return;
            }
            pre=temp;
            temp=temp.next;
            itr++;
        }
    }
    public Node find(int value){
        if(this.empty())return null;
        Node temp=root;
        while(temp!=null){
            if(temp.get_value()==value)return temp;
            temp=temp.next;
        }
        return null;
    }
    public void mrege(List list){
        if(this.empty()){
            root=list.get_root();
            return;
        }
        Node temp=root;
        while(temp.next!=null)temp=temp.next;
        temp.next=list.get_root();
    }
    public void sort(){
        if(this.empty())return;
        Node temp = root;
        while(temp.next!=null){
            Node forw = temp.next;
            while(forw!=null){
                if(temp.get_value()>forw.get_value()){
                    int swap= temp.get_value();
                    temp.set_value(forw.get_value());
                    forw.set_value(swap);
                }
                forw=forw.next;
            }
            temp=temp.next;
        }
    }
}
