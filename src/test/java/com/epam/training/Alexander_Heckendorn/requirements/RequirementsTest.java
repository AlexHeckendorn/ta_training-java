package com.epam.training.Alexander_Heckendorn.requirements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;


public class RequirementsTest {

    @Test
    public void checkArgumentTest() {
        assertDoesNotThrow(() -> Requirements.checkArgument(true));
        assertThrows(IllegalArgumentException.class, () -> Requirements.checkArgument(false));

        assertDoesNotThrow(() -> Requirements.checkArgument(true, "a message"));
        for (String message : List.of("hey", "there", "an error message")) {
            try {
                Requirements.checkArgument(false, message);
            } catch (IllegalArgumentException e) {
                assertEquals(message, e.getMessage());
                continue;
            } catch (Throwable thr) {
                thr.printStackTrace();
                fail("Wrong type of an exception " + thr.getClass() + ":" + thr.getMessage());
            }
            fail("An exception must be thrown");
        }
    }

    @Test
    public void checkStateTest() {
        assertDoesNotThrow(() -> Requirements.checkState(true));
        assertThrows(IllegalStateException.class, () -> Requirements.checkState(false));

        assertDoesNotThrow(() -> Requirements.checkState(true, "a message"));
        for (String message : List.of("hey", "there", "an error message")) {
            try {
                Requirements.checkState(false, message);
            } catch (IllegalStateException e) {
                assertEquals(message, e.getMessage());
                continue;
            } catch (Throwable thr) {
                thr.printStackTrace();
                fail("Wrong type of an exception " + thr.getClass() + ":" + thr.getMessage());
            }
            fail("An exception must be thrown");
        }
    }

    @Test
    public void requireNonNullTest() {
        Assertions.assertDoesNotThrow(() -> Requirements.requireNonNull(new Object()));
        assertThrows(NullPointerException.class, () -> Requirements.requireNonNull(null));

        Assertions.assertDoesNotThrow(() -> Requirements.requireNonNull(new Object(), "a message"));
        for (String message : List.of("hey", "there", "an error message")) {
            try {
                Requirements.requireNonNull(null, message);
            } catch (NullPointerException e) {
                assertEquals(message, e.getMessage());
                continue;
            } catch (Throwable thr) {
                thr.printStackTrace();
                fail("Wrong type of an exception " + thr.getClass() + ":" + thr.getMessage());
            }
            fail("An exception must be thrown");
        }
    }

    @Test
    public void checkElementIndex() {
        assertDoesNotThrow(() -> Requirements.checkIndex(0, 10));
        assertDoesNotThrow(() -> Requirements.checkIndex(3, 10));
        assertDoesNotThrow(() -> Requirements.checkIndex(9, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> Requirements.checkIndex(9, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> Requirements.checkIndex(3, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> Requirements.checkIndex(-1, 2));
    }
}
