package algorithms;

import java.util.*;

public class ThreeSubSetSum {

    public static void main(String[] args){
        int[] nums = {-1, 0, 1, 2, -1, -4};

        System.out.print(Arrays.deepToString(threeSum(nums).toArray()));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        if(nums == null || nums.length < 3) return result;

        int start = nums[0] + nums[1];
        map.put(0 - start, Arrays.asList(nums[0], nums[1]));

        for(int i = 2; i < nums.length; i++){
            if(map.containsKey(nums[i])) {
                List<Integer> subItems = Arrays.asList(map.get(nums[i]).get(0), map.get(nums[i]).get(1), nums[i]);

                result.add(subItems);
            }

            for(int j=0; j<i; j++){
                map.put(0 - (nums[j] + nums[i]), Arrays.asList(nums[j], nums[i]));
            }
        }

        return result;
    }
}
