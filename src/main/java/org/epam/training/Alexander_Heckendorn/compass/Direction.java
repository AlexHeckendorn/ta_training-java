package org.epam.training.Alexander_Heckendorn.compass;

import java.util.Arrays;
import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);


    private final int degrees;

    Direction(int degrees) {
        this.degrees = degrees;
    }

    public static Direction ofDegrees(int degrees) {
        degrees = adjustDegrees(degrees);
        if (degrees < 0 || degrees >= 360) {
            throw new IllegalArgumentException("Invalid degrees value: " + degrees);
        }
        for (Direction direction : Direction.values()) {
            if (direction.degrees == degrees) {
                return direction;
            }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        degrees = adjustDegrees(degrees);
        Direction closest = null;
        int minDifference = Integer.MAX_VALUE;
        for (Direction direction : Direction.values()) {
            int difference = Math.abs(direction.degrees - degrees);
            if (difference <= minDifference) {
                minDifference = difference;
                closest = direction;
            }
        }
        return closest;
    }

    public Direction opposite() {
        return closestToDegrees(degrees + 180);
    }

    public int differenceDegreesTo(Direction direction) {
        int clockwiseDiff = (direction.degrees - this.degrees + 360) % 360;
        int counterclockwiseDiff = (this.degrees - direction.degrees + 360) % 360;
        return Math.min(clockwiseDiff, counterclockwiseDiff);
    }

    private static int adjustDegrees(int degrees) {
        while (degrees < 0) {
            degrees += 360;
        }
        while (degrees >= 360) {
            degrees -= 360;
        }
        return degrees;
    }
}

