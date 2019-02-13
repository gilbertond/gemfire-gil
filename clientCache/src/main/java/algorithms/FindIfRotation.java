package algorithms;

import java.util.Stack;

public class FindIfRotation {
    public static void main(String[] a){
        System.out.println(isWord1RotationOfWord2("fcfcf", "fcfcf"));
    }

    static int isWord1RotationOfWord2(String word1, String word2){
        int isRotation = 1;

        if (word1.length() != word2.length()) return isRotation;

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<word1.length(); i++){
           stack.push(word1.charAt(i));
        }

        for (int i=0; i<word1.length(); i++){
            if(stack.pop() != word2.charAt(i)) isRotation = -1;
        }

        return isRotation;
    }
}
