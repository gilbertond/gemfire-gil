package algorithms;

import java.util.Arrays;

public class ArrayLeftRotation {
    public static void main(String[]a){

        int[] arr = {1,2,3,4,5,6}              ;
        System.out.println(Arrays.toString(leftRotateArray(arr, 2)));
    }

    static int[] leftRotateArray(int[] arr, int k){
        int[] result = new int[arr.length];

        for (int i=0;i<arr.length;i++) {

            int offset;
            if (i<k){
                 offset = arr.length + i - k;
            } else{
                 offset = i - k;
            }

            result[offset] = arr[i];
        }
        return result;
    }
}
