package org.epam.training.Alexander_Heckendorn.meet_strangers;

import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        //Write a program, asks for a number - amount of strangers to meet.
        //Then reads stranger names line by line and prints line by line "Hello, ...".
        Scanner scanner = new Scanner(System.in);
        int numStrangers = scanner.nextInt();
        if(numStrangers == 0){
            System.out.println("Oh, it looks like there is no one here.");
        }else if(numStrangers < 0){
            System.out.println("Seriously? Why so negative?");
        }else{
            scanner.nextLine();
            String[] names = new String[numStrangers];
            for(int i = 1; i <= numStrangers; i++){
                String strangerName = scanner.nextLine();
                names[i-1] = strangerName;
            }
            for(String strangerName:names){
                System.out.println("Hello, "+strangerName);
            }
        }
    }
}
