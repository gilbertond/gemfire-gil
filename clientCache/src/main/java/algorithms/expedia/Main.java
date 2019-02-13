package algorithms.expedia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line = "2\n" +
            "Hello World\n" +
            "\n" +
            "CodeEval\n" +
            "Quick Fox\n" +
            "A\n" +
            "San Francisco";
      
      String[] split = line.split("\n");
      int lineCount = Integer.parseInt(split[0]);
      
      String[] twoWords = new String[lineCount];
      Arrays.fill(twoWords, "");
      
      for(int i=1; i<split.length; i++){
        String current = split[i];
        
        String longest = twoWords[0];
        String secondLongest = twoWords[1];
        
        if(current.length() > longest.length() && current.length()>secondLongest.length()){
          twoWords[0]=current;
          twoWords[1]=longest;
        }
        
        if(current.length() < longest.length() && current.length() > secondLongest.length()){
          twoWords[1]=current;
        }
      }
      
      System.out.println(twoWords[0]);
      System.out.println(twoWords[1]);
    }
}
