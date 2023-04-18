package org.epam.training.Alexander_Heckendorn.decrementing_carousel_with_limit;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel {
    private final int remainingCalls;

    public DecrementingCarouselWithLimitedRun(int capacity, int limit) {
        super(capacity);
        this.remainingCalls = limit;
    }

    public class LimitedRun extends CarouselRun {
        private int calls;
        public LimitedRun() {
            super();
            this.calls = remainingCalls;
        }

        @Override
        public int next() {
            if (calls <= 0) {
                return -1;
            }
            int next = super.next();
            if (next >= 0) {
                calls--;
            }
            return next;
        }
        @Override
        public boolean isFinished() {
            return super.isFinished() || calls <= 0;
        }
    }
        @Override
        public CarouselRun run() {
            if (isRun) {
                return null;
            }
            isRun = true;
            return new LimitedRun();
        }
}