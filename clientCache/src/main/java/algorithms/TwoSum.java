package algorithms;

import java.util.*;

public class TwoSum {
    public static void main(String[] a){
        int[] arr={1,2,4,5,7,-1, 1,6};
        int target=6;

//         System.out.print(Arrays.toString(twoSum(arr, target)));
         System.out.print(usingHashMap2(arr, target));
    }

    public static int[] twoSum(int[] nums, int target) {
//         for(int i=0; i<nums.length;i++){
//          for(int j=1; j<nums.length;j++){
//             if(i != j && (nums[i] + nums[j]) == target){
//                 return new int[]{i, j};
//             }
//         }
//         }

//         return new int[]{};
        return usingHashMap(nums, target);
    }

    static class Pair implements Comparable{
         int val1;
         int val2;

        Pair(int val1, int val2){
            this.val1=val1;
            this.val2=val2;
        }

        @Override
        public String toString() {
            return "["+val1+", "+val2+"]";
        }

        @Override
        public boolean equals(Object obj) {
            Pair p = (Pair) obj;

            return (p.val2==this.val2 && p.val1==this.val1) || (p.val1==this.val2 && p.val2==this.val1);
        }

        @Override
        public int compareTo(Object o) {
            Pair p = (Pair) o;

            return p.compareTo(this);
        }

        @Override
        public int hashCode() {
            int res = 17;
            int hash1 = 31 * res + val1;
            int hash2 = 31 * res + val2;
            res = hash1 + hash2;
            return res;
        }
    }

    //return 1st occurrence
    public static int[] usingHashMap(int[] nums, int target){
        Map<Integer, Integer> added = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int diff = target - nums[i];

            if(added.containsKey(diff)){
                return new int[]{added.get(diff), i};
            }

            added.put(nums[i], i);
        }
        return new int[]{};
    }

    //return count of pairs that sum up
    public static int usingHashMap2(int[] nums, int target){
        Map<Integer, Integer> added = new HashMap<>();


        Set<Pair> pairs = new HashSet<>();

        for (int i=0;i<nums.length;i++){
            int diff = target - nums[i];

            if(added.containsKey(diff)){

                if (doesNotcontain(pairs, nums[i], diff)){
                    pairs.add(new Pair(nums[i], diff));
                }
            }

            added.put(nums[i], i);
        }

        return pairs.size();
    }

    static boolean doesNotcontain(Set<Pair> pairs, int val1, int val2){

        Pair p = new Pair(val1, val2);
        return !pairs.contains(p);
    }
}
