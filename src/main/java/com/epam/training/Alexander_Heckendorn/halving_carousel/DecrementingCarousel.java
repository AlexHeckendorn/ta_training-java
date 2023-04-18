package com.epam.training.Alexander_Heckendorn.halving_carousel;

public class DecrementingCarousel {
    static int capacity;
    int carouselElementCounter = 0;
    static int [] carouselElements;
    boolean isRun = false;
    public DecrementingCarousel(int capacity) {
        DecrementingCarousel.capacity = capacity;
        carouselElements = new int[capacity];

    }
    public boolean addElement(int element) {
        if (isRun || carouselElementCounter >= capacity || element <= 0) {
            return false;
        }
        carouselElements[carouselElementCounter++] = element;
        return true;
    }
    public CarouselRun run() {
        if (isRun) {
            return null;
        }
        isRun = true;
        return new CarouselRun();
    }
}
