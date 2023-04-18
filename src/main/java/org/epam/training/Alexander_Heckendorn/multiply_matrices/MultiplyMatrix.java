package org.epam.training.Alexander_Heckendorn.multiply_matrices;
import java.util.Arrays;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        //get the number of rows and columns of the first matrix aswell
        //as the number of columns in the second matrix
        int numberRows1 = matrix1.length;
        int numberColumns1 = matrix1[0].length;
        int numberColumns2 = matrix2[0].length;
        //when multiplying matrices, the newly created matrix is
        //the size of the rows of the first matrix and the number
        //of columns of the second matrix
        int[][] multipliedMatrix = new int[numberRows1][numberColumns2];
        for(int i = 0; i <numberRows1; i++){
            for(int j = 0; j < numberColumns2; j++){
                int sum = 0;
                //Multiplying the element of the first matrix and the second martrix
                for(int k = 0; k < numberColumns1; k++){
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                multipliedMatrix[i][j] =sum;
            }

        }
        return multipliedMatrix;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] a = {
                {0, 12345},
                {4509, 0},
                {3, 567} };

        int[][] b = {
                {653, 0, 25353},
                {0, 61, 6} };

        int[][] result = multiply(a, b);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }
}
