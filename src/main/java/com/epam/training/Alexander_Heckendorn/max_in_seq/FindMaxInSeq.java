package com.epam.training.Alexander_Heckendorn.max_in_seq;
import java.util.Scanner;

public class FindMaxInSeq {
    public static void main(String[] args) {
        System.out.println(max());
    }
    public static int max(){
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        while (true) {
            int value = scanner.nextInt();
            if (value == 0) {
                break;
            }
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
