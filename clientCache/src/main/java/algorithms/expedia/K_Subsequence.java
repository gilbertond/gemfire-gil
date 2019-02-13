package algorithms.expedia;

public class K_Subsequence {
    public static void main(String[] a){
         System.out.println("Result: " + kSub(3,   new int[] {3,1,2}));
//         System.out.println(kSub(3, Arrays.asList(1,2,3,5)));
//         System.out.println(kSub(3, Arrays.asList(1,3,2,5)));
//         System.out.println(kSub(3, Arrays.asList(1,5,2,5)));
         System.out.println(kSub(5, new int[] {4, 5, 0, -2, -3, 1}));
    }

    static long kSub(int k, int[] nums) {

        int [] sum = new int[nums.length];
        long count = 0;
        sum[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            sum[i] = sum[i-1] + nums[i];
        }

        int [] kVal = new int[k];

        for(int i = 0; i < sum.length; i++){
            int mod = sum[i] % k;

            if(mod == 0)
                count++;

            count += kVal[mod];
            kVal[mod] += 1;

        }
        return count;
    }
}
