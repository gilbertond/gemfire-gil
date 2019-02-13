package algorithms;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        
    }

    public boolean isMatch(String str, String pat) {
        Map<Character, String> map = new HashMap<>();
        return isMatch(str, 0, pat, 0, map);
    }

    boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map) {

        if (i == str.length() && j == pat.length()) return true;
        if (i == str.length() || j == pat.length()) return false;

        char c = pat.charAt(j);

        if (map.containsKey(c)) {
            String s = map.get(c);

            if (i + s.length() > str.length() || !str.substring(i, i + s.length()).equals(s)) {
                return false;
            }

            return isMatch(str, i + s.length(), pat, j + 1, map);
        }

        for (int k = i; k < str.length(); k++) {
            map.put(c, str.substring(i, k + 1));

            if (isMatch(str, k + 1, pat, j + 1, map)) {
                return true;
            }
        }

        map.remove(c);

        return false;
    }

}