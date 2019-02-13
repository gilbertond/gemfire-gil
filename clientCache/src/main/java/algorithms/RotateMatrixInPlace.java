package algorithms;

import java.util.Arrays;

public class RotateMatrixInPlace {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(Arrays.deepToString(rotate90(matrix)));
    }

    static int[][] rotate90(int[][] matrix){

        moveInner(matrix, 0, 0);

        swapLayers(matrix);  //clockwise
        swapLayersAnti(matrix);   //Anticlockwise

        return matrix;

    }

    //When clockwise
    static void swapLayers(int[][] matrix){

        int row = 0;
        for (int col=0; col <= matrix.length/2; col++){
            if (col == matrix.length/2) {
                col = 0;
                row ++;
            }

            if (row == matrix.length) break;

            int temp = matrix[row][col];
            matrix[row][col] = matrix[row][matrix.length - 1 - col];
            matrix[row][matrix.length - 1 - col] = temp;
        }
    }

    static void swapLayersAnti(int[][] matrix){

        for (int row=0; row <= matrix.length/2; row++){
            if (row == matrix.length/2) {
                break;
            }

            int[] temp = matrix[row];
            matrix[row] = matrix[matrix.length - 1 - row];
            matrix[matrix.length - 1 - row] = temp;
        }
    }

    static void moveInner(int[][] matrix, int col, int row) {

        if (row == matrix.length) return;

        int n = matrix[0].length;

        int temp = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = temp;

        if (col < n-1) moveInner(matrix, col+1, row);

        if (col == n-1){
            col = row;
        }
        moveInner(matrix, col+1, row+1);
    }
}

