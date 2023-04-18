package com.epam.training.Alexander_Heckendorn.catch_em_all;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class CatchEmAll {
    static Exception exception = null;

    public static void main(String[] args) throws Exception {
        try {
            riskyMethod();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Resource is missing", e);
        } catch (IOException e) {
            throw new IllegalArgumentException("Resource error", e);
        } catch (ArithmeticException | NumberFormatException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void riskyMethod() throws Exception {
        if (exception instanceof IOException) {
            throw exception;
        } else if (exception instanceof RuntimeException) {
            throw exception;
        } else {
            //risky method throws some other exception
            throw new Exception("unknown exception");
        }
    }
}
