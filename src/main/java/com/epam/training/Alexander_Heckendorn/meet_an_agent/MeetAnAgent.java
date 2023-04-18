package com.epam.training.Alexander_Heckendorn.meet_an_agent;

import java.util.Scanner;

public class MeetAnAgent {
    final static int PASSWORD = 133976; //You can change pass, but don't change the type

    public static void main(String[] args) {
        //put you code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an input number: ");
        int input = scanner.nextInt();
        if(input == PASSWORD){
            System.out.println("Hello,Agent");
        }else{
            System.out.println("Access denied");
        }
    }
}
