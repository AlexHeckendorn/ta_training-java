package com.epam.training.Alexander_Heckendorn.halving_carousel;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(int capacity) {
        super(capacity);

    }

    @Override
    public CarouselRun run() {
        if (isRun) {
            return null;
        }
        isRun = true;
        return new HalvingCarouselRun();
    }

    private class HalvingCarouselRun extends CarouselRun {

        @Override
        public int next() {
            if (isRunning) {
                return -1;
            }
            // Create a variable to ensure that 'next' iterates at least once through the
            // carouselElements array and if no positive integers are found it returns -1
            int count = 0;
            while (count < carouselElements.length && carouselElements[positionArray %= carouselElements.length] <= 0) {
                positionArray++;
                count++;
            }
            if (count == carouselElements.length) {
                isRunning = true;
                return -1;
            }
            int value = carouselElements[positionArray];
            carouselElements[positionArray] = value / 2;
            positionArray++;
            return value;
        }
    }
}
