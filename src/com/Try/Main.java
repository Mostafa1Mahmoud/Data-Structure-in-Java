package com.Try;

import java.util.Scanner;
/*
*
* This Code was Written By Eng : Mostafa Mahmoud Mostafa
*
* */

public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.Insert_Node(10);
        tree.Insert_Node(5);
        tree.Insert_Node(15);
        tree.Insert_Node(1);
        tree.Insert_Node(8);
        tree.Insert_Node(13);
        tree.Insert_Node(18);
        tree.Insert_Node(0);
        tree.Insert_Node(9);
        tree.Insert_Node(14);
        tree.Insert_Node(17);
        tree.display_Inorder(tree.getRoot());
        tree.removeLeaf(tree.getRoot());
        System.out.println("--------------------");
        tree.display_Inorder(tree.getRoot());
    }
}
