package com.epam.training.Alexander_Heckendorn.words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if (sample == null || words == null || words.length == 0) {
            return 0;
        }

        int count = 0;
        for (String word : words) {
            if (word.trim().equalsIgnoreCase(sample.trim())) {
                count++;
            }
        }
        return count;
    }

    public static String[] splitWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return null;
        }
        String[] words = text.split("[,.:;?!\\s]+");
        List<String> nonEmptyWords = new ArrayList<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                nonEmptyWords.add(word);
            }
        }
        if (nonEmptyWords.isEmpty()) {
            return null;
        }
        return nonEmptyWords.toArray(new String[0]);
    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null || path.isEmpty()) {
            return null;
        }

        // Check if path is already in the correct format
        boolean isUnix = isUnixPath(path);
        boolean isWin = isWindowsPath(path);
        if ((isUnix && !toWin) || (isWin && toWin)) {
            return path;
        }

        // Check for invalid path format
        if (isUnix && path.contains("\\")) {
            return null;
        } else if (isWin && path.contains("/") && !path.contains("\\\\")) {
            return null;
        }

        // Replace Unix path separators with Windows path separators
        if (toWin) {
            path = path.replace('/', '\\');
        } else {
            path = path.replace('\\', '/');
        }

        // Replace Unix ~ with Windows user path
        if (path.startsWith("~/") || path.equals("~")) {
            path = path.replaceFirst("~", getUserDir(toWin));
        } else if (path.startsWith("~")) {
            return null;
        }

        // Replace Unix / with Windows drive letter
        if (toWin && path.startsWith("/")) {
            path = getUserDrive() + ":" + path;
        } else if (!toWin && path.matches("[A-Za-z]:.*")) {
            path = path.replaceFirst("[A-Za-z]:", "");
        }

        return path;
    }

    private static boolean isUnixPath(String path) {
        return path.startsWith("/") || path.startsWith("~");
    }

    private static boolean isWindowsPath(String path) {
        return path.matches("[A-Za-z]:.*");
    }

    private static String getUserDir(boolean toWin) {
        String userDir = System.getProperty("user.home");
        if (toWin) {
            userDir = userDir.replace('/', '\\');
        } else {
            userDir = userDir.replace('\\', '/');
        }
        return userDir;
    }

    private static String getUserDrive() {
        return System.getenv("SystemDrive");
    }

    public static String joinWords(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }

        // Filter out empty strings
        List<String> nonEmptyWords = Arrays.stream(words)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        if (nonEmptyWords.isEmpty()) {
            return null;
        }

        // Join non-empty words with commas
        String joined = String.join(", ", nonEmptyWords);

        // Wrap in brackets and return
        return "[" + joined + "]";
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}