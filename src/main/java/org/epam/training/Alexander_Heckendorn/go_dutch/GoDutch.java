package org.epam.training.Alexander_Heckendorn.go_dutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int billTotal = scanner.nextInt();
        if (billTotal < 0){
            System.out.println("Bill total amount cannot be negative");
            return;
        }
        int numFriends = scanner.nextInt();
        if(numFriends <= 0){
            System.out.println("Number of friends cannot be negative or zero");
            return;
        }
        double totalAmount = billTotal * 1.1;
        int amountPerFriend = (int)Math.round(totalAmount / numFriends);
        System.out.println(amountPerFriend);
    }
}
