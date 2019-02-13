package algorithms;

import java.util.HashMap;
import java.util.Map;

@Deprecated
public class ChocolateStation {
    public static void main(String[]a){
        int[] arr = {10, 6, 11, 4, 7, 1};
        int cost = 5;
        System.out.println(getProfit(arr, cost));
    }

    static int getProfit(int[] arr, int cost){

        int tracker = 0;
        Map<Integer, int[]> map = new HashMap<>();
        map.put(-1, new int[]{0,0});

        for (int index = 0; index<arr.length; index++){
            int current = arr[index];
            int[] prevArr = map.containsKey(index-1)? map.get(index-1): new int[]{0,0};

            tracker = index;
            int currentProfit = prevArr[0]-current;
            if (prevArr[1]+current < 0) break;

            map.put(index, new int[]{current, currentProfit});
        }

        System.out.println(tracker);
        return cost * map.getOrDefault(tracker, new int[]{0,0})[0];
    }
}
