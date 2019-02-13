package algorithms;

import java.util.Arrays;

public class MatrixRotation {
    public static void main(String[] r){

        int[][] input = {{1,2,3}, {4,5,6}, {7,8,9}};

        System.out.println(Arrays.deepToString(rotateMatrix(input)));
    }

    static int[][] rotateMatrix(int[][] input){
        int[][] result = new int[input.length][input[0].length];
        int[][] result2 = new int[input.length][input[0].length];
        for (int i=0; i<input.length; i++){
            for (int j=0; j<input.length; j++){
                int temp = input[i][j];
                result[i][j] = input[j][i];
                result[j][i] = temp;
            }
        }

        //reverse
        for (int j=0; j<result.length; j++){
            int[] temp = result[j];

            result2[j] = result[result.length-1-j];
            result2[result.length-1-j] = temp;
        }

        return result2;
    }
}
