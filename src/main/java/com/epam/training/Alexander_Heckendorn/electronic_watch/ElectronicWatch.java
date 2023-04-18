package com.epam.training.Alexander_Heckendorn.electronic_watch;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total_seconds = scanner.nextInt();
        int hours = total_seconds/3600;
        hours%=24;
        int minutes =(total_seconds%3600)/60;
        int seconds = total_seconds%60;
        String time = String.format("%01d:%02d:%02d",hours,minutes,seconds);
        System.out.println(time);
    }
}
