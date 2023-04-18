package com.epam.training.Alexander_Heckendorn.gradually_decreasing_carousel;

public class GraduallyDecreasingCarousel extends DecrementingCarousel {
    int[] decrementValues;
    int[] currentDecrementValues;
    boolean isFirstTime;

    public GraduallyDecreasingCarousel(int capacity) {
        super(capacity);
        decrementValues = new int[capacity];
        currentDecrementValues = new int[capacity];
        isFirstTime = true;
    }

    @Override
    public CarouselRun run() {
        if (isRun) {
            return null;
        }
        isRun = true;
        return new GraduallyDecreasingCarouselRun();
    }

    private class GraduallyDecreasingCarouselRun extends CarouselRun {
        private int position = 0;
        int decrement = 1;

        @Override
        public int next() {
            int beforeDecreasing;
            if (isFinished())
                return -1;
            else {
                beforeDecreasing = carouselElements[position];
                carouselElements[position] -= decrement;
                do {
                    position++;
                    if (position == carouselElements.length) {
                        decrement++;
                        position = 0;
                    }
                } while ((carouselElements[position] <= 0) && !isFinished());
            }
            return beforeDecreasing;
        }

        @Override
        public boolean isFinished() {
            return allNegative(carouselElements);
        }
    }
}