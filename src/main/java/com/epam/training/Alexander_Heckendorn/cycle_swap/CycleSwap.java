package com.epam.training.Alexander_Heckendorn.cycle_swap;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int last = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = last;
    }
    public static void cycleSwap(int[] array, int shift) {
        if (array == null || array.length <= 1) {
            return;
        }
        shift %= array.length;
        for (int k = 0; k < shift; k++) {
            int last = array[array.length - 1];
            for (int i = array.length - 1; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = last;
        }
    }
}