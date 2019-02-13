package algorithms;

import java.util.Arrays;

public class MaxSubsequenceInStrings {
    public static void main(String[]a){

        int[] arr = {-1, 2, -3, 4, -5, 6};

        for(int i=0; i<arr.length; i+=2){
           if (arr[i] < 0){
               arr = swap(arr, i, i+1);
           }
        }

        System.out.println(Arrays.toString(arr));
    }

    static int[] swap(int[] arr, int index, int next){
        int temp = arr[index];
        arr[index] = arr[next];
        arr[next] = temp;

        return arr;
    }
}
