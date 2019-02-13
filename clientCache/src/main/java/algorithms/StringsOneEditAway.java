package algorithms;

import java.util.Arrays;

public class StringsOneEditAway {
    public static void main(String[] args){
        String s1 = "pale";
        String s2 = "eldx";
        
        System.out.println(oneEditAway(s1, s2));
    }

    static boolean oneEditAway(String s1, String s2){
        if (s1.length() - s2.length() > 1 || s2.length() - s1.length() > 1) return false; //Size diff can't be more than 1

        int count = 0;
        int i=0, j=0;

        int min = Math.min(s1.length(), s2.length());

        char[] sorted1 = s1.length()>s2.length()?s1.toCharArray():s2.toCharArray();
        Arrays.sort(sorted1);

        char[] sorted2 = s1.length()<s2.length()?s2.toCharArray():s1.toCharArray();
        Arrays.sort(sorted2);

        for (int index = 0; index < min; index++) {
           if (sorted1[i] == sorted2[j]) {
               i++;
               j++;
           } else {
               i++;
               count++;

               if (count > 1) return false;
           }
        }

        return true;
    }
}
