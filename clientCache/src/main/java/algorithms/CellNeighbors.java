package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CellNeighbors {
    public static void main(String[] argd){
        System.out.println("Input:    " + Arrays.toString(new int[]{1,1,1,0,1,1,1,1}));
        System.out.println("Expected: " + Arrays.toString(new int[]{0,0,0,0,0,1,1,0}));
        System.out.println("Result:   " + cellCompete(new int[]{1,1,1,0,1,1,1,1}, 2));
    }

    public static List<Integer> cellCompete(int[] states, int days)
    {
        List<Integer> results = new ArrayList();

        for (int i=0; i<states.length ; i++){
            results.add(i, states[i]);
        }
        // WRITE YOUR CODE HERE
        for (int i=1; i<=days ; i++){

            for(int j=0; j<results.size(); j++){
                int leftNeighbor = j==0?0:states[j-1];
                int rightNeighbor = j==results.size()-1?0:states[j+1];

                if(leftNeighbor==1 && rightNeighbor==0) results.set(j, 1);
                if(leftNeighbor==0 && rightNeighbor==0) results.set(j, 0);
                if(leftNeighbor==0 && rightNeighbor==1) results.set(j, 1);
                if(leftNeighbor==1 && rightNeighbor==0) results.set(j, 1);
                if(leftNeighbor==1 && rightNeighbor==1) results.set(j, 0);
            }

            for (int j=0; j<results.size(); j++){
                states[j] = results.get(j);
            }
        }

        return results;
    }
}
