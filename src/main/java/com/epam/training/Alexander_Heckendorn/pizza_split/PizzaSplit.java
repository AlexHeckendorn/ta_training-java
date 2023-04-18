package com.epam.training.Alexander_Heckendorn.pizza_split;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = scanner.nextInt();
        int numberOfSlicesPerPizza = scanner.nextInt();
        int totalSlices = numberOfPeople * numberOfSlicesPerPizza;
        int slicesPerPerson = totalSlices / numberOfPeople;
        int leftoverSlices = totalSlices % numberOfPeople;
        if (leftoverSlices != 0) {
            numberOfSlicesPerPizza += numberOfPeople - leftoverSlices;
            slicesPerPerson = numberOfSlicesPerPizza / numberOfPeople;
        }

        int pizzasNeeded = (int) Math.ceil((double) totalSlices / slicesPerPerson);

        System.out.println(pizzasNeeded);
    }
}

















