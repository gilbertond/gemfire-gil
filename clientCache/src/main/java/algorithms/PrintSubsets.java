package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintSubsets {
    public static void main(String[] args){

        int [] arr = {1, 2, 3};
        System.out.println(Arrays.deepToString(getSubsets(arr, arr.length-1).toArray()));
    }

    static List<List<Integer>> getSubsets(int[] arr, int index){

        List<List<Integer>> allSubsets;

        if(arr==null) return null;

        if (index < 0 ) {
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<>());
            
        }else {
            List<List<Integer>> subsets = new ArrayList<>();

            allSubsets = getSubsets(arr,  index-1);
            
            for (List subset : allSubsets) {
                List<Integer> innerSets = new ArrayList<>();
                innerSets.add(arr[index]);
                innerSets.addAll(subset);

                subsets.add(innerSets);
            }

            allSubsets.addAll(subsets);
        }

        return allSubsets;
    }
}
