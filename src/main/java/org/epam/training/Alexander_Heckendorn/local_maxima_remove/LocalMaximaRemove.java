package org.epam.training.Alexander_Heckendorn.local_maxima_remove;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};
        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array) {
        if (array == null || array.length <= 1) {
            return Arrays.copyOf(array, array.length);
        }
        int[] result = new int[array.length];
        int count = 0;
        if (array[0] <= array[1]) {
            result[count++] = array[0];
        }
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i-1] && array[i] > array[i+1]) {
                continue;
            }
            result[count++] = array[i];
        }
        if (array[array.length-1] <= array[array.length-2]) {
            result[count++] = array[array.length-1];
        }
        return Arrays.copyOf(result, count);
    }
}


