package com.epam.training.Alexander_Heckendorn.average;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;
        while (true) {
            int value = scanner.nextInt();
            if (value == 0) {
                break;
            }
            sum += value;
            count++;
        }
        int average = sum / count;
        System.out.println(average);
    }

}