package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Pair{
    int i;
    int j;

    Pair(int x,int y){
        i=x;
        j=y;
    }
}

public class CombinationOfFourSumsToN {
    public static void main(String[] a){
        int[] arr = {1, 5, 9, 1, 0, 6, 10};
        Arrays.sort(arr);
        int sum = 7;

        System.out.println(get4Numbers(arr, sum));
    }
    public static int get4Numbers(int a[],int sum)
    {
        int len=a.length;
        Map<Integer, Pair> sums = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            // 'sums' hastable holds all possible sums a[k] + a[l]
            // where k and l are both less than i

            for (int j = i + 1; j < len; ++j) {
                int current = a[i] + a[j];
                int rest = sum - current;
                // Now we need to find if there're different numbers k and l
                // such that a[k] + a[l] == rest and k < i and l < i
                // but we have 'sums' hashtable prepared for that
                if (sums.containsKey(rest)) {
                    // found it
                    return 1;
                }
            }

            // now let's put in 'sums' hashtable all possible sums
            // a[i] + a[k] where k < i
            for (int k = 0; k < i; ++k) {
                sums.put(a[i] + a[k],new Pair(i, k));
            }
        }
        return 0;
    }
}
