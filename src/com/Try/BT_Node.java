package com.Try;

public class BT_Node {
    private int data;
    private BT_Node leftChild;
    private BT_Node rightChild;

    public BT_Node(int data) {
        this.data=data;
    }

    public void setData(int data) {
        this.data=data;
    }

    public int getData(){
        return this.data;
    }
    public BT_Node getLeftChild(){
        return this.leftChild;
    }
    public BT_Node getRightChild(){
        return this.rightChild;
    }
    public void setLeftChild(BT_Node Node){
        this.leftChild = Node;
    }
    public void setRightChild(BT_Node Node){
        this.rightChild = Node;
    }
    /*
    public void insert_right(BT_Node Node){
        this.rightChild=Node;
    }
    public void insert_left(BT_Node Node){
        this.leftChild=Node;
    }*/
}
