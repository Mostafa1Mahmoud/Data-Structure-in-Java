package com.Try;

public class double_list {
    private link head;
    private link tail;
    public double_list(){}
    public double_list(int data){
        head=tail=new link(data);
    }
    public link get_head() {
        return head;
    }
    public link get_tail(){
        return tail;
    }
    public void set_head(link head){
        this.head=head;
    }
    public void set_tail(link tail){
        this.tail=tail;
    }
    public boolean empty(){
        return head==null&&tail==null;
    }
    public void print_front(){
        if(this.empty())return;
        link temp=head;
        while(temp!=null){
            System.out.println(temp.get_data());
            temp=temp.next;
        }
    }
    public void print_back(){
        if(this.empty())return;
        link temp = tail;
        while(temp!=null){
            System.out.println(temp.get_data());
            temp=temp.pre;
        }
    }
    public void push_front(int data){
        if(this.empty()){
            head=tail=new link(data);
            return;
        }
        link link = new link(data);
        link.next=head;
        head=link;
        link.next.pre=link;
    }
    public void pop_front(){
        if(this.empty())return;
        if(head==tail){
            head=tail=null;
            return;
        }
        head=head.next;
        head.pre=null;
    }
    public void push_back(int data){
        if(this.empty()){
            head=tail=new link(data);
            return;
        }
        link link = new link(data);
        link.pre=tail;
        link.pre.next=link;
        tail=link;
    }
    public void pop_back(){
        if(this.empty())return;
        if(head==tail){
            head=tail=null;
            return;
        }
        tail.pre.next=null;
        tail=tail.pre;
    }
    public void insert_sorted(int data){
        if(head==null){
            head=new link(data);
            return;
        }
        link link = new link (data);
        link temp=head, pre=head;
        while (temp != null && data > temp.get_data()){
            pre = temp;
            temp = temp.next;
        }
        if(temp==pre){
            link.next=head;
            head=link;
            return;
        }
        pre.next = link;
        link.next = temp;
    }
    public void delete_by_data(int data){
        if(this.empty())return;
        link temp = head;
        while(temp!=null){
            if(temp.get_data()==data){
                if(head==temp&&head==tail){
                    head=tail=null;
                    return;
                }
                if(head==temp){
                    head.next.pre=null;
                    head=head.next;
                    return;
                }
                if(tail==temp){
                    tail.pre.next=null;
                    tail=tail.pre;
                    return;
                }
                temp.pre.next=temp.next;
                temp.next.pre=temp.pre;
            }
            temp=temp.next;
        }
    }
    public void delete_by_index(int index){
        if(this.empty())return;
        link temp = head;
        int itr=0;
        while(temp!=null){
            if(itr==index){
                if(head==temp&&head==tail){
                    head=tail=null;
                    return;
                }
                if(head==temp){
                    head.next.pre=null;
                    head=head.next;
                    return;
                }
                if(tail==temp){
                    tail.pre.next=null;
                    tail=tail.pre;
                    return;
                }
                temp.pre.next=temp.next;
                temp.next.pre=temp.pre;
            }
            temp=temp.next;
            itr++;
        }
    }
    public void merge(double_list list){
        tail.next=list.get_head();
        list.get_head().pre=tail;
        list.set_head(head);
        tail= list.get_tail();
    }
    public void Bubble_sort(){
        if(this.empty())return;
        link temp = head;
        while(temp.next!=null){
            link forw = temp.next;
            while(forw!=null){
                if(temp.get_data()>forw.get_data()){
                    int swap= temp.get_data();
                    temp.set_data(forw.get_data());
                    forw.set_data(swap);
                }
                forw=forw.next;
            }
            temp=temp.next;
        }
    }
    public void Reverse(){
        // current for traversing and temp for swaping
        link current = head , temp = null;
        while(current.next != null){
            current = current.next;
            temp = current.pre.next;
            current.pre.next = current.pre.pre;
            current.pre.pre = temp;
        }
        temp = current.next;
        current.next = current.pre;
        current.pre = temp;
        temp = head;
        head = tail;
        tail =  temp;
    }
    public void Insertion_sort(){

    }
}
