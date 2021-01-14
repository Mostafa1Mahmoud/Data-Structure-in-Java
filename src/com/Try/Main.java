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


    }
}
