package com.automation.selenium;

import java.util.Scanner;

public class JavaPractice {
    public static void main(String[] args){
        String str = "Hello";
        int a = 10;
        int b = 20;
        System.out.println(str+ a + b);
        System.out.println(2.0 / 4 * 50);

        String str1 = "Welcome %s";
        String username = new Scanner(System.in).nextLine();
        System.out.println(String.format(str1,username));
    }
}
