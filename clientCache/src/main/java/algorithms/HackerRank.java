package algorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HackerRank {

    private static final Scanner scanner = new Scanner(System.in);

    static List<Integer> tracker = new ArrayList();

    public static void main(String[] args) throws IOException {
        String[] words = {"this", "that", "when"}  ;

        System.out.println(Arrays.toString(sortWordsByScore(words)));
    }

    static String[] sortWordsByScore(String[] words) {
        /*
         * Write your code here.
         */

        if(words.length == 0) return new String[0];
        String[] sorted = new String[words.length];

        int minScore = -1; //minScore(words[0]);
        int currentIndex = 1;
        int index = 0;

        getMinScoreWordIndex(words, minScore);

        System.out.println(tracker);
        while(currentIndex <= tracker.size()){


            System.out.println(tracker.get(index));
            
            sorted[index] = words[tracker.get(index)];

            index++;
            currentIndex++;
//            tracker.clear();
        }

        return sorted;
    }

    static int minScore(String word){
        char[] alphabets = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};

        int score = 0;
        for(int j=0; j<word.length(); j++){
            boolean isVowel = false;
            for(int x = 1; x<=vowels.length; x++){
                char[] val = word.toCharArray();

                char y =  val[j];
                char z = vowels[x-1];
                if(val[j] == vowels[x-1]){
                    
                    isVowel = true;
                    score += (x*2);
//                    System.out.println(y +" : "+ z + " Score: "+score);
                }

            }

            if(!isVowel) {

                for (int x = 1; x <= alphabets.length; x++) {
                    if (word.toCharArray()[j] == alphabets[x - 1]) score += (x);
                }
            }
        }

                System.out.println(">>>>" +word + " has Score: "+ score);

        return score;
    }

    static void getMinScoreWordIndex(String[] words, int minScore){
//        int minIndex = 0;
        int currentMinScore = minScore;

        for(int i=0; i < words.length; i++){
            if (!tracker.contains(i)) {
                String word = words[i];
                int score = minScore(word);

                if(currentMinScore == -1){
                   currentMinScore=score+1;
                    tracker.add(i);
                }
                if(score < currentMinScore){
                    currentMinScore = score;
                    tracker.add(i);

//                    minIndex = i;
                }


            }



//            if(i == words.length-1) return  currentIndex ;


        }
//        return minIndex;
    }
}
