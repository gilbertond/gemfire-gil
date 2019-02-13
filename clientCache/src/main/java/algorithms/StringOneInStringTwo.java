package algorithms;

import java.util.Arrays;

public class StringOneInStringTwo {
    public static void main(String[] a){

        System.out.println(isFound("abbat", "cat"));
    }

    static boolean isFound(String s1, String s2)  {

        if (s1.length() ==0 || s2.length()==0)  return false;

        int[] s1_arr = fillArraqy(s1);
        int[] s2_arr =fillArraqy(s2);

        System.out.println(Arrays.toString(s1_arr));
        System.out.println(Arrays.toString(s2_arr));
        
        for (int i=0; i<26; i++){

            //At least one if found
//            if (s2_arr[i] >= 0 && s2_arr[i]>s1_arr[i]) return false;

            //check for lower char a and b
            if (s1_arr[i] < s2_arr[i] && i<2) return false;

            //If not found, check previous 2
            if (s1_arr[i] != s2_arr[i] && i>=2) {
                if (s1_arr[i-2] < 0 || s1_arr[i-1] < 0) return false;
            }
        }
        return true;
    }

    static int[] fillArraqy(String value){

        int offset = (int) 'a';

        int[] s_arr = new int[26];
        Arrays.fill(s_arr, -1);
        for (int i =0; i < value.length(); i++){

            int index = value.charAt(i) - offset;
            if(s_arr[index] == -1) s_arr[index] = 0;

            s_arr[index]++;
        }

        return s_arr;
    }
}
