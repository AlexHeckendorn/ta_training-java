package com.epam.training.Alexander_Heckendorn.compass;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DirectionTest {

    @ParameterizedTest
    @MethodSource
    void ofDegrees(Direction expected, int degrees) {
        assertEquals(expected, Direction.ofDegrees(degrees));
    }

    @ParameterizedTest
    @MethodSource
    void closestToDegrees(Direction expected, int degrees) {
        assertEquals(expected, Direction.closestToDegrees(degrees));
    }

    @ParameterizedTest
    @MethodSource
    void opposite(Direction expected, Direction source) {
        assertEquals(expected, source.opposite());
    }

    @ParameterizedTest
    @MethodSource
    void differenceDegreesTo(int expected, Direction source, Direction param) {
        assertEquals(expected, source.differenceDegreesTo(param));
    }

    public static Stream<Arguments> ofDegrees() {
        return Stream.of(
                arguments(Direction.N, 0),
                arguments(Direction.NE, 45),
                arguments(Direction.E, 90),
                arguments(Direction.SE, 135),
                arguments(Direction.S, 180),
                arguments(Direction.SW, 225),
                arguments(Direction.W, 270),
                arguments(Direction.NW, 315),

                arguments(Direction.N, 360),
                arguments(Direction.NE, 765),
                arguments(Direction.NW, -45),
                arguments(Direction.SW, -135),

                arguments(null, 44),
                arguments(null, 1111)
        );
    }

    public static Stream<Arguments> closestToDegrees() {
        return Stream.of(
                arguments(Direction.N, 0),
                arguments(Direction.NE, 45),
                arguments(Direction.E, 90),
                arguments(Direction.SE, 135),
                arguments(Direction.S, 180),
                arguments(Direction.SW, 225),
                arguments(Direction.W, 270),
                arguments(Direction.NW, 315),

                arguments(Direction.N, 360),
                arguments(Direction.NE, 765),
                arguments(Direction.NW, -45),
                arguments(Direction.SW, -135),

                arguments(Direction.NE, 44),
                arguments(Direction.S, 200),
                arguments(Direction.SW, 205),
                arguments(Direction.NE, 1111)
        );
    }

    public static Stream<Arguments> opposite() {
        return Stream.of(
                arguments(Direction.N, Direction.S),
                arguments(Direction.NE, Direction.SW),
                arguments(Direction.E, Direction.W),
                arguments(Direction.SE, Direction.NW),
                arguments(Direction.S, Direction.N),
                arguments(Direction.SW, Direction.NE),
                arguments(Direction.W, Direction.E),
                arguments(Direction.NW, Direction.SE)
        );
    }

    public static Stream<Arguments> differenceDegreesTo() {
        return Stream.of(
                arguments(180, Direction.N, Direction.S),
                arguments(180, Direction.NE, Direction.SW),
                arguments(180, Direction.E, Direction.W),
                arguments(180, Direction.SE, Direction.NW),
                arguments(180, Direction.S, Direction.N),
                arguments(180, Direction.SW, Direction.NE),
                arguments(180, Direction.W, Direction.E),
                arguments(180, Direction.NW, Direction.SE),

                arguments(45, Direction.N, Direction.NW),
                arguments(45, Direction.N, Direction.NE),
                arguments(45, Direction.NE, Direction.N),

                arguments(45, Direction.S, Direction.SE),
                arguments(45, Direction.SE, Direction.E),
                arguments(45, Direction.E, Direction.SE),

                arguments(135, Direction.S, Direction.NE),
                arguments(135, Direction.SE, Direction.N),
                arguments(135, Direction.SE, Direction.W),

                arguments(90, Direction.S, Direction.E),
                arguments(90, Direction.N, Direction.E),
                arguments(90, Direction.NW, Direction.SW)
        );
    }
}