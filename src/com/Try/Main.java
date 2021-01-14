package com.Try;

import java.util.Scanner;

/*
*
* This Code was Written By Eng : Mostafa Mahmoud Mostafa
*
* */
public class Main {
    public static void main(String[] args) {
        double_list list = new double_list();
        for(int i = 0; i < 10 ;i++)list.push_back(i);
        list.Reverse();
        list.print_front();
        System.out.println("------------");
        for(int i = 0;i < 5;i++)list.push_front(i);
        list.print_front();
        System.out.println("------------");
        list.Insertion_sort();
        list.print_front();
        System.out.println("------------");
        list.print_back();
    }
}
