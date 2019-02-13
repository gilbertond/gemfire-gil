package algorithms;

import java.util.Arrays;
import java.util.List;

public class Pythogorean {
    public static void main(String[] args){
           int[] arr = {3, 1, 4, 6, 5} ;
           Integer[] arr2 = {3, 1, 4, 6, 5} ;

            System.out.println(searchPythogoreanBetter(arr2));
    }

    //----Naiive approach-----//
    static boolean searchPythogorean(int[] arr){
        for (int i=0; i<arr.length; i++){
            int a = arr[i];

            for (int j=0; j<arr.length; j++){
                int b = arr[j];

                for (int k=0; k<arr.length; k++){
                    int c = arr[k];

                    if ((Math.pow(a, 2) + Math.pow(b, 2)) == Math.pow(c, 2))  {
                        System.out.println(a + "+" + b + "+" + c);
                       return true; 
                    }
                }
            }
        }

        return false;
    }

    //----Naiive approach-----//
    static boolean searchPythogoreanBetter(Integer[] arr){
         List<Integer> arr2 = Arrays.asList(arr.clone());

         for (int i=0; i<arr2.size(); i++){
             arr2.set(i, arr2.get(i) * arr2.get(i));
         }

        for (int i=0; i<arr.length; i++){

            for (int j=0; j<arr.length; j++){

                if (arr2.contains((int) (Math.pow(arr[i], 2) + Math.pow(arr[j], 2)))){
                    return true;
                }
            }
        }

        return false;
    }
}
