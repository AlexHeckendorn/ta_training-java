package org.epam.training.Alexander_Heckendorn.spiral;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int[][] result = new int[rows][columns];
        int num = 1;
        int topRow = 0, bottomRow = rows - 1, leftCol = 0, rightCol = columns - 1;
        while (topRow <= bottomRow && leftCol <= rightCol) {
            // Traverse the top row from left to right
            for (int col = leftCol; col <= rightCol; col++) {
                result[topRow][col] = num++;
            }
            topRow++;
            // Traverse the right column from top to bottom
            for (int row = topRow; row <= bottomRow; row++) {
                result[row][rightCol] = num++;
            }
            rightCol--;
            // Traverse the bottom row from right to left
            if (topRow <= bottomRow) {
                for (int col = rightCol; col >= leftCol; col--) {
                    result[bottomRow][col] = num++;
                }
                bottomRow--;
            }
            // Traverse the left column from bottom to top
            if (leftCol <= rightCol) {
                for (int row = bottomRow; row >= topRow; row--) {
                    result[row][leftCol] = num++;
                }
                leftCol++;
            }
        }
        return result;
    }
}
