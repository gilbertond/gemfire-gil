package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderTips {
    public static void main(String[] a){
        int[] Ai = {1, 4, 3, 2, 7, 5, 9, 6};
        int[] Bi = {1, 2, 3, 6, 5, 4, 9, 8};

         getMaxTip(8, 4, 4, Ai, Bi);

         System.out.println(TOTAL);
    }

    static void getMaxTip(int N, int X, int Y, int[] tipPossibilityA, int[] tipPossibilityB){

        if(N < 1 || N > 105) throw new IllegalArgumentException("Invalid order number!!!");
        if(tipPossibilityA.length < 1 || tipPossibilityA.length > 104 || tipPossibilityB.length < 1 || tipPossibilityB.length > 104)
                throw new IllegalArgumentException("Invalid order sizes!!!");

        if ((X + Y) > N) throw new IllegalArgumentException("Combined orders greater than total order!!!");

        int[][] matrix = new int[tipPossibilityA.length][tipPossibilityB.length];

            for (int i = 0; i < tipPossibilityA.length; i++) {
                for (int j = 0; j < tipPossibilityB.length; j++) {
//                    if (i == j){
//                        matrix[i][j] = -1;
//                    }  else {
                       matrix[i][j] = tipPossibilityA[i] + tipPossibilityB[j];
//                    }
                }
            }

            System.out.println(Arrays.deepToString(matrix));

            retrieveMaxValues(matrix, new ArrayList<>(), new ArrayList<>());
    }
       static int TOTAL = 0;

    static int retrieveMaxValues(int[][] matrix, List<Integer> ignoreRow, List<Integer> ignoreCol){
        int MAX = 0;
        int newRowIgnore = 0;
        int newColIgnore = 0;

        if (ignoreRow.size()==matrix.length) return TOTAL;

        for (int i = 0; i < matrix.length; i++) {
            if (ignoreRow.contains(i)) continue;
            for (int j = 0; j < matrix[i].length; j++) {

                if (ignoreCol.contains(j)) continue;

                if (MAX < matrix[i][j]){
                    MAX = Math.max(MAX, matrix[i][j]);

                    newColIgnore = j;
                    newRowIgnore = i;
                }
            }
        }

        System.out.println(ignoreRow.size() + "======>>>" + MAX);

        ignoreRow.add(newRowIgnore);
        ignoreCol.add(newColIgnore);

        return TOTAL+= MAX + retrieveMaxValues(matrix, ignoreRow, ignoreCol);
    }
}
