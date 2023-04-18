package com.epam.training.Alexander_Heckendorn.snail;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int h = scanner.nextInt();
        if (h == 1) {
            System.out.println("1");
        } else if (a <= b ){
            System.out.println("Impossible");
        } else{
            int days = (h - b -1) / (a - b) + 1;
            System.out.println(days);
        }
    }
}
