package algorithms;

import java.util.HashSet;

class reverseWords {

    public static void main(String[] args){
//        char[] s = getArray(" Hello World! ");
//        System.out.print("[");
//        print(s);
//        System.out.print("]") ;
//        reverse_words (s);
//        System.out.println();
//
//        System.out.print("[");
//        print(s);
//        System.out.print("]");
//        System.out.println();
//        System.out.println(Arrays.equals(s, getArray("World! Hello")));

//        s = getArray("    Quick brown fox jumped   over the lazy   dog           ");
//        print(s);
//        reverse_words(s);
//        print(s);
//        System.out.println(Arrays.equals(s, getArray("           dog   lazy the over   jumped fox brown Quick    ")));



        remove_duplicates("abbabcddbabcdeedebc".toCharArray());
    }

    public static void str_rev(char[] str, int start, int end) {
        if (str == null || str.length < 2) {
            return;
        }

        while (start < end) {

            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;

            start++;
            end--;
        }
    }

    public static void reverse_words (char[] sentence) {

        // Here sentence is a null-terminated string ending with char '\0'.

        if (sentence == null || sentence.length == 0) {
            return;
        }

        // To reverse all words in the string, we will first reverse
        // the string. Now all the words are in the desired location, but
        // in reverse order: "Hello World" -> "dlroW olleH".

        int len = sentence.length;
        str_rev(sentence, 0, len-2);

        // Now, let's iterate the sentence and reverse each word in place.
        // "dlroW olleH" -> "World Hello"

        int start = 0;
        int end;
        while (true) {
            // find the  start index of a word while skipping spaces.
            while (sentence[start] == ' ') {
                ++start;
            }

            if (sentence[start] == '\0') {
                break;
            }

            // find the end index of the word.
            end = start+1;
            while (sentence[end] != '\0' && sentence[end] != ' ') {
                ++end;
            }

            // let's reverse the word in-place.
            str_rev (sentence, start, end-1);

            start = end;
        }
    }
    static void print(char[] s) {
        int i = 0;
        while (s[i] != '\0') {
            System.out.print(s[i]);
            ++i;
        }
//        System.out.println();
    }
    static char[] getArray(String t) {
        char[] s = new char[t.length() + 1];
        int i = 0;
        for (;i < t.length(); ++i) {
            s[i] = t.charAt(i);
        }
        s[i] = '\0';
        return s;
    }


    static void remove_duplicates(char[] str){
        if(str == null || str.length == 0) System.out.println();
        HashSet<Character> set = new HashSet<>();

        for(int i=0; i<str.length; i++){
            if(!set.contains(str[i])) {
                System.out.print(str[i]);

            }
            set.add(str[i]);
        }
    }
}
