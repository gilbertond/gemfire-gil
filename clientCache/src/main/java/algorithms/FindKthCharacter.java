package algorithms;

import java.util.ArrayList;
import java.util.List;

public class FindKthCharacter {
    public static void main(String[] a){

        int iterations = 3;
        int number = 5;
        int kth = 5;
        System.out.println(printKthCharacter(5, 5, 3));
    }

    static char printKthCharacter(int number, int kth, int iterations){

        String numberString = Integer.toBinaryString(number);

        System.out.println(numberString);

        for (int i=1; i<=iterations; i++){
            numberString = transform(numberString);
        }


        System.out.println(numberString);
        return numberString.charAt(kth-1);
    }

    static String transform(String s){
        List<String> map = new ArrayList<>();

        for (int i=0; i<s.length(); i++){
            System.out.println(s.charAt(i));

            map.add(s.charAt(i)=='0'? "01" : "10");
        }

//        System.out.println(map.toString());

        return map.toString().replace(",", "").replace(" ", "").replace("[", "").replace("]", "");
    }
}
