package algorithms.expedia;

import java.util.*;

public class CustomSort {
    public static void main(String[] a){

        customSort(Arrays.asList(4, 5, 6, 5, 4, 3));     //Expected: 3,6,4,4,5,5
    }

    public static void customSort(List<Integer> arr){
         if (arr ==null || arr.size() > Math.pow(10,5)) return;

         List<Pair> sorted = new ArrayList<>();

         Map<Integer, Pair> maps = new HashMap<>();

         for (Integer val : arr){
             int count = 1;
             Pair pair = new Pair(val, 0);

             if(maps.containsKey(val)){
                 maps.get(new Pair(val, 0));

                count += pair.count;
                pair.count = count;
             }

             maps.put(val, pair);
         }

         for (Integer val : arr){
             sorted.add(new Pair(val, maps.get(val).count));
         }

         Collections.sort(sorted);

         System.out.println(Arrays.deepToString(sorted.toArray()));
    }
}

class Pair implements Comparable<Pair>{
    Integer value;
    Integer count;

    Pair(int value, int count){
       this.value = value;
       this.count = count;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.count == o.count){
            return this.value.compareTo(o.value);
        } else
            return this.count.compareTo(o.count);
    }

    @Override
    public boolean equals(Object obj) {
        return this.value.equals(((Pair)obj).value);
    }

    @Override
    public String toString() {
        return ""+ this.value +"";
    }
}
