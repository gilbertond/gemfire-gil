package algorithms;

import java.util.HashSet;
import java.util.Set;

public class StringSegmentationWordDictonary {

    public static void main(String[] a){

        Set<String> dict = new HashSet<>();
        dict.add("pear");
        dict.add("appele");
        dict.add("apple");
        dict.add("pier");
        dict.add("pie");

        System.out.println(can_segment_string("applepierpier", dict));
    }

    public static boolean can_segment_string(String s, Set<String> dict) {
            Set<String> solved = new HashSet<>();

         return findWord(s, dict, solved);
    }

    private static boolean findWord(String s, Set<String> dict, Set<String> solved) {

        for (int i=1; i<=s.length(); i++){
            String first = s.substring(0, i);

            if (dict.contains(first)){
                String second = s.substring(i);

                if (second==null || second.length()==0 || dict.contains(second)) return true;

                if (!solved.contains(second)){ //We dont want to solve what failed already...
                   if (findWord(second, dict, solved)){
                       return true;
                   }

                   solved.add(second);
                }
            }
        }

        return false;
    }
}
