package com.epam.training.Alexander_Heckendorn.max;

public class MaxMethod {
    public static int max(int[] values) {
        int maxVal = Integer.MIN_VALUE;
        for (int value : values) {
            if (value > maxVal) {
                maxVal = value;
            }
        }
        return maxVal;
    }
}
