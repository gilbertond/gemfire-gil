package mum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class bitilde {
    public static void main(String[] r){
        int[] arr1 = {1, 1, 1, 5, 5, 5, 5, 8, 8, 8};
        System.out.print(isStepped(arr1));

        int[] arr2 = {1, 1, 5, 5, 5, 5, 8, 8, 8};
        System.out.print(isStepped(arr2));

        int[] arr3 = {5, 5, 5, 15};
        System.out.print(isStepped(arr3));

        int[] arr4 = {3, 3, 3, 2, 2, 2, 5, 5, 5};
        System.out.print(isStepped(arr4));

        int[] arr5 = {3, 3, 3, 2, 2, 2, 1, 1, 1};
        System.out.print(isStepped(arr5));

        int[] arr6 = {1, 1, 1};
        System.out.print(isStepped(arr6));

        int[] arr7 = {1, 1, 1, 1, 1, 1, 1};
        System.out.print(isStepped(arr7));

//          System.out.println(closestFibonacci(34));

    }

    static int hasNValues(int[] arr, int n){
        Set<Integer> added = new HashSet<>();

        if (arr==null || arr.length==0 || n<0) return 0;
        if (n==0 && arr.length>0) return 0;

        int count = 0;

        for (int i=0; i<arr.length; i++){
            if (!added.contains(arr[i])) {
                count++;

                added.add(arr[i]);
            }
        }

        return count==n?1:0;
    }


    //ascending and 3+ occurence of each distinct item
    static int isStepped(int [] a){
        Map<Integer, Integer> valueCountMap = new HashMap<>();
        if (a==null || a.length < 3) return 0;


        for(int i = 1; i < a.length; i++)
        {
            if(a[i-1] > a[i])
            {
                return 0;
            }
        }

        for (int i=0; i<a.length; i++){
            if (valueCountMap.containsKey(a[i])){
                int oldCount = valueCountMap.get(a[i]);
                valueCountMap.put(a[i], oldCount+1);
            }else {
                valueCountMap.put(a[i], 1);
            }
        }

        boolean hasLess = false;

        for (Integer count:valueCountMap.values()){
            if (count<3) {
                hasLess = true;
                break;
            }
        }

        return hasLess?0:1;
    }

    static int closestFibonacci(int n){
        int first = 1;
        int second = 1;

        int ans = 1;
        int next = first + second;
        while ( next <= n ){
            first = second;
            second = next;

            next = first + second;

            ans = next-first;
        }

        return ans;
    }
}
