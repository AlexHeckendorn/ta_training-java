package org.epam.training.Alexander_Heckendorn.meet_a_stranger;

import java.util.Scanner;

public class MeetAStranger {
    public static void main(String[] args) {
        //Write a program, which read a String from System.in and print "Hello, <input string>"
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Hello, "+input);
    }
}
