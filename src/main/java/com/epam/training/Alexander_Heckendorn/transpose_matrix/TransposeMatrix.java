package com.epam.training.Alexander_Heckendorn.transpose_matrix;
import java.util.Arrays;

public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        //get the rows and columns of the original matrix
        int rows = matrix.length;
        int cols = matrix[0].length;
        //create a new matrix of the same size
        int[][] transposed = new int[cols][rows];
        //now transpose the values of the rows and columns into the new matrix
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                transposed[i][j] = matrix[j][i];
            }
        }
        return transposed;
    }
    public static void main(String[] args) {
        System.out.println("Test your code here!\n");
        // Get a result of your code
        int[][] matrix = {
                {1, 2},
                {7, -13} };

        int[][] result = transpose(matrix);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }

}
