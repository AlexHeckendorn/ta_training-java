package org.epam.training.Alexander_Heckendorn.decrementing_carousel;

import static org.epam.training.Alexander_Heckendorn.decrementing_carousel.DecrementingCarousel.carouselElements;
public class CarouselRun {
    int positionArray = 0;
    boolean isRunning = false;
    public int next() {
        if (isRunning) {
            return -1;
        }
        //Create a variable to ensure that 'next' iterates at least once through the
        //carouselElements array and if no positive integers are found it returns -1
        int count = 0;
        while (count < carouselElements.length && carouselElements[positionArray %= carouselElements.length] <= 0) {
            positionArray++;
            count++;
        }
        if (count == carouselElements.length) {
            isRunning = true;
            return -1;
        }
        return carouselElements[positionArray++]--;
    }
    public static int[] removeTheElement(int[] arr, int index)
    {
        //If the array is empty or the index is not within the array range, return the original array
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
        // Create another array of size one less than the original
        int[] anotherArray = new int[arr.length - 1];
        // Copy the elements except the index from original array to the newly created array
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        // return the created resulting array
        return anotherArray;
    }
    public static boolean allNegative (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) return false;
        }
        return true;
    }
    public boolean isFinished() {
        for (int var : carouselElements) {
            if (var > 0) {
                return false;
            }
        }
        return true;
    }
}