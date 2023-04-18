package com.epam.training.Alexander_Heckendorn.decrementing_carousel_with_limit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CodeComplianceTest {

    @Test
    void testInheritance() {
        assertEquals(DecrementingCarousel.class, DecrementingCarouselWithLimitedRun.class.getSuperclass());
    }
}
